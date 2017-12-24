package com.elton.app.criterioAceitacao.cucumber.stepdefs;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.elton.app.dto.TaskDTO;
import com.elton.app.service.TaskService;
import com.elton.app.utils.AbstractDefs;
import com.elton.app.utils.factory.TaskMother;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;


public class TaskStepDefs extends AbstractDefs{

	@Autowired
	private TaskService taskService;

	private TaskDTO DTO = new TaskDTO();

	private static final String CAMPO_START_DATE = "startDate";


	private static Map<String, String> mapaCampos = new HashMap<String, String>();

	static {
		mapaCampos.put("Name", "setName");
		mapaCampos.put("startDate", "setStartDate");
	}

	@Override
	public Map<String, String> getMapaCampos() {
		return mapaCampos;
	}

	@Dado("^uma Task em registro$")
	public void uma_task_em_registro() throws Throwable {
		DTO = TaskMother.getTaskDTOPadrao();
	}

	@Dado("^uma Task cadastrada$")
	public void uma_Task_cadastrada() throws Throwable {
		uma_task_em_registro();
		tento_salvar_a_Task();
	}

	@Quando("^informo o nome da Task \"([^\"]*)\"$")
	public void informo_o_nome_da_task(final String novoNome) throws Throwable {
		DTO.setName(novoNome);
	}

	@Quando("^tento salvar a Task$")
	public void tento_salvar_a_Task() throws Throwable {
		try {
			DTO = taskService.persist(DTO);
		} catch (final RuntimeException re) {
			tratarErrosDeExcecao(re);
		}
	}

	@Quando("^tento alterar a Task$")
	public void tento_alterar_a_task() throws Throwable {
		try {
			DTO = taskService.update(DTO);
		} catch (final RuntimeException re) {
			tratarErrosDeExcecao(re);
		}
	}

	@Quando("^tento alterar a task desatualizada$")
	public void tento_alterar_a_task_desatualizada() throws Throwable {
		final TaskDTO taskDesatualizada = DTO;
		try {
			taskService.update(DTO);
			taskService.update(taskDesatualizada);
		} catch (final RuntimeException re) {
			tratarErrosDeExcecao(re);
		}
	}

	@E("^a informação obrigatória (.*) da task com o valor \"([^\"]*)\"$")
	public void tento_incluir_uma_Task_com_a_informacao_obrigatoria_igual_a(final String campo, final String valor)
			throws Throwable {
		Object objValor;
		if(campo.equals(CAMPO_START_DATE)) {
			objValor = getStringComoData(valor);
		}else {
			objValor = valor;
		}
		preencheCampo(DTO, campo, objValor);
	}

	@Dado("^a informação obrigatória (.*) da task tem seu valor alterado para o valor \"([^\"]*)\"$")
	public void a_informacao_obrigatoria_do_fator_tem_seu_valor_alterado_para_o_valor(final String campo,
			final String valor)
					throws Throwable {
		Object objValor;
		if(campo.equals(CAMPO_START_DATE)) {
			objValor = getStringComoData(valor);
		}else {
			objValor = valor;
		}
		preencheCampo(DTO, campo, objValor);
	}

	@Entao("^A Task foi incluída com sucesso.$")
	public void a_task_foi_incluída_com_sucesso() throws Throwable {
		Assert.assertNotNull(DTO.getId());
	}

	@Entao("^A Task foi alterada com sucesso.$")
	public void a_task_foi_alterada_com_sucesso() throws Throwable {
		final TaskDTO taskRecuperada = taskService.findById(DTO.getId());
		Assert.assertNotNull(taskRecuperada.getId());
		Assert.assertNotNull(taskRecuperada.getLastUpdateTime());
		Assert.assertEquals(DTO.getName(), taskRecuperada.getName());
		Assert.assertEquals(DTO.getStartDate(), taskRecuperada.getStartDate());
	}

	@Entao("^falha:Name is Required.$")
	public void fail_name_is_required() throws Throwable {
		Assert.assertTrue(verificaRetornoExcecao("Name is Required."));
	}

	@Entao("^falha:Start Date is Required.$")
	public void fail_start_date_is_required() throws Throwable {
		Assert.assertTrue(verificaRetornoExcecao("Start Date is Required."));
	}

	@Entao("^falha:Entidade desatualizada, favor atualizar a página para concluir alteração.$")
	public void fail_entidade_desatualizada_lock_optimistick() throws Throwable {
		Assert.assertTrue(verificaRetornoExcecao("Entidade desatualizada, favor atualizar a página para concluir alteração."));
	}

}
