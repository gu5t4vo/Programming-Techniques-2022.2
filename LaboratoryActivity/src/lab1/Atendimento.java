package lab1;

import java.util.ArrayList;
import java.util.Calendar;

public class Atendimento {

	private Cliente cliente;
	private ArrayList<Servico> listaServico;
	private Calendar data;
	private Cabeleireiro cabeleireiro;

	public Atendimento(Cliente cliente, Cabeleireiro cabeleireiro) {
		this.cliente = cliente;
		this.data = Calendar.getInstance();
		this.cabeleireiro = cabeleireiro;
		listaServico = new ArrayList<Servico>();
	}

	public void setListServico(ArrayList<Servico> lista) {
		listaServico= lista;
	}
	public void addServico(Servico serv) {
		listaServico.add(serv);
	}

	public String imprimir() {
		String saida = "";

		saida += "----------------------------------------------------\n";
		saida += "\n******* Cliente:  *******";
		saida += "\n id: " + this.cliente.getId();
		saida += "\n Nome: " + this.cliente.getNome();
		saida += "\n CPF:  " + this.cliente.getCPF();

		saida += "\n\n*******  Cabeleiro:  *******  ";
		saida += "\n id: " + this.cabeleireiro.getId();
		saida += "\n Nome: " + this.cabeleireiro.getNome();
		saida += "\n CPF:  " + this.cabeleireiro.getCpf();

		saida += "\n\n*******  Servicos:  *******  ";
		for (Servico servico : listaServico) {
			saida += "\n id: " + servico.getId();
			saida += "\n nome: " + servico.getNome();
			saida += "\n descricao: " + servico.getDescricao();
			saida += "\n valor: " + servico.getValor() + "\n";
		}

		saida += "----------------------------------------------------";

		return saida;
	}

	public float totServicesValue(){

		float bill = 0f;

		for (Servico service: listaServico) {
			
		}
	}

}
