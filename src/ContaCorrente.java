
public class ContaCorrente extends Conta {
	private float saldoContaCorrente;

	public void exibirDados() {
		System.out.println("O nome do titular : " + this.getPessoa().getNome());
		System.out.println("O CPF do titular :  " + this.getPessoa().getCPF());
		System.out.println("O numero da conta : " + this.getNumero());
		System.out.println("A sua agencia : " + this.getAgencia());
		System.out.println("O seu saldo : " + this.saldoContaCorrente);

	}

	public float getSaldoContaCorrente() {
		return saldoContaCorrente;
	}

	public void setSaldoContaCorrente(float saldoContaCorrente) {
		this.saldoContaCorrente = saldoContaCorrente;
	}

	@Override
	public String toString() {
		return "ContaCorrente [saldoContaCorrente=" + saldoContaCorrente + "]";
	}

	@Override
	public void abrirConta() {
		if (this.getContaAtiva() == false) {
			System.out.println("Seja bem vindo! " + "sua Conta Corrente está aberta");
			this.setContaAtiva(true);
		} else {
			System.err.println("Conta já está aberta");
		}

	}

	@Override
	public void fecharConta() {
		if (this.getContaAtiva() == true) {
			this.setContaAtiva(false);
			System.out.println("Conta Corrente fechada com sucesso");
		} else {
			System.err.println("Impossivel fechar um conta inativa");
		}
	}

	@Override
	public void sacar(float valor) {
		if (valor <= this.saldoContaCorrente) {
			this.saldoContaCorrente = saldoContaCorrente - valor;
		} else {
			System.err.println("Saldo insuficiente");
		}

	}

	@Override
	public void depositar(float valor) {
		this.saldoContaCorrente = saldoContaCorrente + valor;

	}

}
