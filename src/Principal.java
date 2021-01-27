
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		String nome, cpf, fim;
		int num;
		float valor;

		ContaCorrente cc = new ContaCorrente();
		ContaPoupanca cp = new ContaPoupanca();

		System.out.println("------------------- JAVA BANK --------------------");
		nome = JOptionPane.showInputDialog("Seja bem vindo ao banco digital JAVA BANK! Por favor, digite seu nome: ");
		cpf = JOptionPane.showInputDialog("Digite seu CPF: ");
		Pessoa p1 = new Pessoa(nome, cpf);
		do {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Escolha h� op��o desejada: 1 - Abrir conta corrente || 2 - Abrir conta poupan�a || 3- Abrir ambas"));

			if (num > 3 || num < 1) {
				System.out.println("Op��o inv�lida! ");
			} else {
				switch (num) {
				case 1:
					cc.abrirConta();

					break;
				case 2:
					cp.abrirConta();

					break;

				case 3:
					cc.abrirConta();
					cp.abrirConta();

					break;

				}
			}
			fim = JOptionPane.showInputDialog("Deseja repetir? (S / N) ");
		} while (!fim.equalsIgnoreCase("n"));

		do {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite qual opera��o bancaria deseja efetuar: 1 - Verificar saldo conta corrente|| 2 - Sacar da conta corrente || 3 - Depositar da conta corrente || 4 - Transferir para outra conta "));

			if (num > 4 || num < 1) {
				System.out.println("Op��o inv�lida! ");
			} else {
				switch (num) {
				case 1:
					cc.getSaldoContaCorrente();

					break;
				case 2:
					valor = Float.parseFloat(JOptionPane.showInputDialog("Qual o valor do saque: "));
					cc.sacar(valor);
					break;

				case 3:
					valor = Float.parseFloat(JOptionPane.showInputDialog("Qual o valor do deposito: "));
					cc.depositar(valor);

					break;

				case 4:
					valor = Float.parseFloat(JOptionPane.showInputDialog("Qual o valor da transfer�ncia: "));
				}
				fim = JOptionPane.showInputDialog("Deseja fazer outra opera��o? (S / N) ");
			}
		} while (!fim.equalsIgnoreCase("n"));

		do {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					" 1 - Verificar saldo conta poupan�a || 2 - Sacar da conta poupan�a || 3 - Depositar da conta corrente || 4 - CP: Transferir para outra conta"));

			if (num > 4 || num < 1) {
				System.out.println("Op��o inv�lida! ");
			} else {
				switch (num) {
				case 1:
					cc.getSaldoContaCorrente();

					break;
				case 2:
					valor = Float.parseFloat(JOptionPane.showInputDialog("Qual o valor do saque: "));
					cc.sacar(valor);
					break;

				case 3:
					valor = Float.parseFloat(JOptionPane.showInputDialog("Qual o valor do deposito: "));
					cc.depositar(valor);

					break;

				case 4:
					valor = Float.parseFloat(JOptionPane.showInputDialog("Qual o valor da transfer�ncia: "));
					cp.transferir(cp, valor);
				}

				fim = JOptionPane.showInputDialog("Deseja fazer outra opera��o? (S / N) ");
			}
		} while (!fim.equalsIgnoreCase("n"));

	}
}
