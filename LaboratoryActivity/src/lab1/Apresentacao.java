package lab1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Apresentacao {

	private Agendamento carregarDadosParaTesteAgendamento() {

		// clientes
		Cliente cliente = new Cliente("080.388.788-95");
		cliente.setId(1);
		cliente.setNome("Pedro");

		Cabeleireiro cabeleireiro = new Cabeleireiro("Ana", "033.333.333-13");

		// agendamento
		Agendamento agendamento = new Agendamento(cliente, cabeleireiro);
		Calendar data = Calendar.getInstance();
		data.set(2022, 9, 27, 20, 30);
		agendamento.setData(data);

		return agendamento;

	}

	public Atendimento carregarDadosParaTesteAtendimento() {
		// clientes
		Cliente cliente1 = new Cliente("080.388.788-95");
		cliente1.setId(1);
		cliente1.setNome("Pedro");

		// servicos
		Servico servico1 = new Servico();
		servico1.setId(1);
		servico1.setNome("Corte de cabelo");
		servico1.setDescricao("Corte de cabelo legal");
		servico1.setValor(150);

		Servico servico2 = new Servico();
		servico2.setId(2);
		servico2.setNome("Hidratação facial");
		servico2.setDescricao(
				"Hidratante Antissinais para redução de linhas de expressão, suavizando sinais de cansaço");
		servico2.setValor(100);

		Servico servico3 = new Servico();
		servico3.setId(3);
		servico2.setNome("Massagem relaxante");
		servico3.setDescricao(
				"Trata-se de manobras especializadas empregadas no músculo, conferindo ao indivíduo relaxamento e alívio muscular. Além de produzir efeitos nos sistemas muscular e nervoso, essa massagem age com eficácia nos sistemas linfático, circulatório e respiratório.");
		servico3.setValor(100);

		// cabeleireiro
		Cabeleireiro cabeleireiro1 = new Cabeleireiro("Antonio", "044.444.444-55");

		// atendimentos
		Atendimento atendimento1 = new Atendimento(cliente1, cabeleireiro1);
		atendimento1.addServico(servico1);
		atendimento1.addServico(servico2);
		atendimento1.addServico(servico3);

		return atendimento1;

	}

	public Cliente carregarCliente(Scanner entrada) {
		System.out.println("Informe o cliente: ");
		System.out.println("cpf do cliente: ");
		Cliente c = new Cliente(entrada.next());
		System.out.println("\nid do cliente: ");
		c.setId(entrada.nextInt());
		System.out.println("\nnome do cliente: ");
		c.setNome(entrada.next());
		System.out.println("\n\n");
		return c;
	}

	public ArrayList<Servico> carregarServico(Scanner entrada) {
		ArrayList<Servico> aux = new ArrayList<Servico>();
		System.out.println("Informe dados sobre os servico(s)");
		String op = "";
		do {
			Servico s = new Servico();
			System.out.println("\nNome do servico:");
			s.setNome(entrada.next());

			System.out.println("\nDescricao do servico:");
			s.setDescricao(entrada.next());

			System.out.println("\nValor do servico:");
			s.setValor(entrada.nextFloat());

			aux.add(s);
			System.out.println("Digite sair ou qualquer tecla para adiocar novo servico:");
			op = entrada.next();

		} while (!(op.equals("sair")));
		return aux;
	}

	public Atendimento dadosCarregadosDoTecladoAtendimento() {
		Scanner entrada = new Scanner(System.in);
		Cliente cliente = carregarCliente(entrada);
		Cabeleireiro cabeleireiro = carregarCabeleireiro(entrada);
		Atendimento a = new Atendimento(cliente, cabeleireiro);
		a.setListServico(carregarServico(entrada));
		return a;
	}

	private Cabeleireiro carregarCabeleireiro(Scanner entrada) {

		System.out.println("Informe o cabeleireiro: ");
		System.out.print("\nnome do cabeleireiro: ");
		String nome = entrada.next();
		System.out.print("\ncpf do cabeleireiro: ");
		String cpf = entrada.next();
		Cabeleireiro c = new Cabeleireiro(nome, cpf);

		System.out.print("\nid do cabeleireiro: ");
		c.setId(entrada.nextInt());

		return c;
	}

	public static void main(String[] args) {

		Apresentacao a = new Apresentacao();
		/* Questao 1 */
		// Atendimento atendimento = a.carregarDadosParaTesteAtendimento();
		// System.out.println(atendimento.imprimir());
		//
		// Agendamento agendamento = a.carregarDadosParaTesteAgendamento();
		// System.out.println(agendamento.imprimir());

		/* Questao 2 */
		Atendimento atendimento2 = a.dadosCarregadosDoTecladoAtendimento();
		System.out.println(atendimento2.imprimir());

	}

}
