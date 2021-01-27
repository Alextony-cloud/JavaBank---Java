
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
			System.out.println("Seja bem vindo! " + "sua Conta Poupan�a est� aberta");
			this.setContaAtiva(true);
			this.setAgencia(41482);
			this.setNumero(8549);
			this.setSaldoContaPoupanca(0);
		} else {
			System.err.println("Conta j� est� aberta");
		}

	}

	@Override
	public void fecharConta() {
		if (this.getContaAtiva() == true) {
			this.setContaAtiva(false);
			System.out.println("Conta Poupan�a fechada com sucesso");
		} else {
			System.err.println("Impossivel fechar um conta inativa");
		}
	}

	@Override
	public void sacar(float valor) {
		if (valor <= this.saldoContaPoupanca) {
			this.saldoContaPoupanca = saldoContaPoupanca - valor;
			System.out.println("Voc� sacou R$ " + valor + " da sua conta poupan�a");
		} else {
			System.err.println("Saldo insuficiente");
		}

	}

	@Override
	public void depositar(float valor) {
		this.saldoContaPoupanca = saldoContaPoupanca + valor;
		System.out.println("Voc� depositou R$ " + valor + " na sua conta poupan�a");

	}

	@Override
	public void transferir(Conta outraConta, float valor) {
		if (valor <= this.saldoContaPoupanca) {
			sacar(valor);
			outraConta.depositar(valor);
			System.out.println("Voc� transferiu R$ " + valor + " para sua conta corrente");
		} else {
			System.out.println("N�o poder� transferir valor maior que o saldo");
		}

	}
}
