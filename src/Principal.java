
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		String nome, cpf, opcao, fim;
		int num;
		float valor;

		ContaCorrente cc = new ContaCorrente();
		ContaPoupanca cp = new ContaPoupanca();
		

		System.out.println("------------------- JAVA BANK --------------------");
		do {
			nome = JOptionPane.showInputDialog(
					"Seja bem vindo ao banco digital JAVA BANK! Precisamos que você insira alguns dados para nos conhecermos mais! Por favor, digite Seu nome: ");
			cpf = JOptionPane.showInputDialog("Digite seu CPF: ");
			Pessoa p1 = new Pessoa(nome, cpf);
			cc.exibirDados();

			opcao = JOptionPane
					.showInputDialog("Olá! Verifique os dados que você inseriu e diga se está correto -> Dados: [Nome: "
							+ nome + " -- CPF: " + cpf + "]"
							+ " \n Digite: 1 - Se estiver correto ou 2- para inserir os dados novamente: ");
		} while (!opcao.equalsIgnoreCase("1"));

		do {

			opcao = JOptionPane.showInputDialog("Digite opção 1- Abrir contas ||  2 - Fechar contas");
			if (opcao.equalsIgnoreCase("1")) {

				do {
					num = Integer.parseInt(JOptionPane.showInputDialog(
							"Escolha há opção desejada: 1 - Abrir conta corrente || 2 - Abrir conta poupança || 3- Abrir ambas"));

					if (num > 3 || num < 1) {
						System.out.println("Opção inválida! ");
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

			} else {

				do {
					num = Integer.parseInt(JOptionPane.showInputDialog(
							"Escolha há opção desejada: 1 - Fechar conta corrente || 2 - Fechar conta poupança || 3- Fechar ambas"));

					if (num > 3 || num < 1) {
						System.out.println("Opção inválida! ");
					} else {
						switch (num) {
						case 1:
							cc.fecharConta();

							break;
						case 2:
							cp.fecharConta();

							break;

						case 3:
							cc.fecharConta();
							cp.fecharConta();

							break;

						}

					}

					fim = JOptionPane.showInputDialog("Deseja repetir? (S / N) ");
				} while (!fim.equalsIgnoreCase("n"));

			}
			opcao = JOptionPane.showInputDialog("Deseja voltar para as operações iniciais? (S / N)");
		} while (!opcao.equalsIgnoreCase("n"));

		opcao = JOptionPane.showInputDialog("Em qual conta deseja entrar: 1 - Conta Corrente || 2 - Conta Poupança");
		if (opcao.equalsIgnoreCase("1")) {

			do {
				num = Integer.parseInt(JOptionPane.showInputDialog(
						"Digite qual operação bancaria deseja efetuar: 1 - Verificar saldo conta corrente|| 2 - Sacar da conta corrente || 3 - Depositar da conta corrente || 4 - Transferir para outra conta "));

				if (num > 4 || num < 1) {
					System.out.println("Opção inválida! ");
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
						opcao = JOptionPane.showInputDialog("Para qual conta deseja transferir: ");
						valor = Float.parseFloat(JOptionPane.showInputDialog("Qual o valor da transferência: "));
						cc.transferir(cp, valor);
					}
					fim = JOptionPane.showInputDialog("Deseja fazer outra operação? (S / N) ");
				}
			} while (!fim.equalsIgnoreCase("n"));

		} else {
			do {
				num = Integer.parseInt(JOptionPane.showInputDialog(
						" 1 - Verificar saldo conta poupança || 2 - Sacar da conta poupança || 3 - Depositar da conta corrente || 4 - CP: Transferir para outra conta"));

				if (num > 4 || num < 1) {
					System.out.println("Opção inválida! ");
				} else {
					switch (num) {
					case 1:
						cp.getSaldoContaPoupanca();

						break;
					case 2:
						valor = Float.parseFloat(JOptionPane.showInputDialog("Qual o valor do saque: "));
						cp.sacar(valor);
						break;

					case 3:
						valor = Float.parseFloat(JOptionPane.showInputDialog("Qual o valor do deposito: "));
						cp.depositar(valor);

						break;

					case 4:
						opcao = JOptionPane.showInputDialog("Para qual conta deseja transferir: ");
						valor = Float.parseFloat(JOptionPane.showInputDialog("Qual o valor da transferência: "));

						cp.transferir(cc, valor);
					}

				}

				fim = JOptionPane.showInputDialog("Deseja fazer outra operação? (S / N) ");
			} while (!fim.equalsIgnoreCase("n"));
		
		
		}
	}
}
