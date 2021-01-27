
public class ContaPoupanca extends Conta {
	private float saldoContaPoupanca;

	public float getSaldoContaPoupanca() {
		return saldoContaPoupanca;
	}

	public void setSaldoContaPoupanca(float saldoContaPoupanca) {
		this.saldoContaPoupanca = saldoContaPoupanca;
	}

	@Override
	public String toString() {
		return "ContaPoupanca [saldoContaPoupanca=" + saldoContaPoupanca + "]";
	}

	@Override
	public void abrirConta() {
		if (this.getContaAtiva() == false) {
			System.out.println("Seja bem vindo! " + "sua Conta Poupança está aberta");
			this.setContaAtiva(true);
			this.setAgencia(41482);
			this.setNumero(8549);
			this.setSaldoContaPoupanca(0);
		} else {
			System.err.println("Conta já está aberta");
		}

	}

	@Override
	public void fecharConta() {
		if (this.getContaAtiva() == true) {
			this.setContaAtiva(false);
			System.out.println("Conta Poupança fechada com sucesso");
		} else {
			System.err.println("Impossivel fechar um conta inativa");
		}
	}

	@Override
	public void sacar(float valor) {
		if (valor <= this.saldoContaPoupanca) {
			this.saldoContaPoupanca = saldoContaPoupanca - valor;
			System.out.println("Você sacou R$ " + valor + " da sua conta poupança");
		} else {
			System.err.println("Saldo insuficiente");
		}

	}

	@Override
	public void depositar(float valor) {
		this.saldoContaPoupanca = saldoContaPoupanca + valor;
		System.out.println("Você depositou R$ " + valor + " na sua conta poupança");

	}

	@Override
	public void transferir(Conta outraConta, float valor) {
		if (valor <= this.saldoContaPoupanca) {
			sacar(valor);
			outraConta.depositar(valor);
			System.out.println("Você transferiu R$ " + valor + " para sua conta corrente");
		} else {
			System.out.println("Não poderá transferir valor maior que o saldo");
		}

	}
}
