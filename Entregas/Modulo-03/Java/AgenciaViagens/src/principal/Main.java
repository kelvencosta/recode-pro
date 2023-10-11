package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import principal.DAO.ClienteDAO;
import principal.DAO.DestinoDAO;
import principal.DAO.ReservaDAO;

public class Main {
	
	static Cliente cliente = new Cliente();
	static ClienteDAO clienteDAO = new ClienteDAO();
	static Reserva reserva = new Reserva();
	static ReservaDAO reservaDAO = new ReservaDAO();

	public static void main(String[] args) {
		menu();
	}

	//Este método exibe o menu principal e lida com a escolha do usuário. Dependendo da escolha, ele chama outros métodos.
	public static void menu() {
		Scanner input = new Scanner(System.in);

		System.out.printf("%13s Escolha o serviço%n%n", "");
		System.out.printf(
				"(1)Comprar passagens %5s (2)Acompanhar requerimento " + "%n(3)Deletar conta %10s(4)Atualizar conta%n",
				"", "");
		System.out.println("(5)Sair");
		System.out.print("Opção: ");

		int escolha = input.nextInt();

		System.out.println("\n\n");

		switch (escolha) {
		case 1:
			comprarPassagens();
			break;
		case 2:
			System.out.println("Informações de reservas\n");
			reservaDAO.obterInformacoesReserva();
			menu();
			break;
		case 3:
			System.out.println("Deletar Contar\n");
			deletarConta();
			break;
			
		case 4:
			System.out.println("Atualizar conta\n");
			atualizarConta();
			break;
			
		case 5:
			clienteDAO.fecharConexao();
	        reservaDAO.fecharConexao();
	        System.out.println("Obrigado pela preferência e confiança.");
		   break;

		default:
			System.out.println("             ! Escolha invalida !\n         ");
			menu();
			break;
		}
	}

	//Este método guia o usuário através do processo de compra de passagens, solicitando informações como CPF e, se necessário, criando um novo cliente.
	public static void comprarPassagens() {
	    Scanner input = new Scanner(System.in);
	    System.out.print("Você possui uma conta? (1)Sim (2)Não: ");

	    int escolha = input.nextInt();

	    if (escolha == 1) {
	        System.out.print("Informe o seu CPF: ");
	        input.nextLine();

	        String cpf = input.nextLine();
	        int codCliente = clienteDAO.obterCodigoClientePorCPF(cpf);

	        if (codCliente != -1) {
	            Cliente clienteExistente = clienteDAO.mostrarDadosPorCPF(cpf);
	            reserva.setCliente(clienteExistente);
	        } else {
	            System.out.println("Cliente não encontrado. Por favor, crie um novo cliente.");
	            criarNovoCliente(input);
	        }

	        escolherDestino();

	    } else if (escolha == 2) {
	        criarNovoCliente(input);
	        escolherDestino();
	    } else {
	        System.out.println("Opção inválida.");
	    }
	}

	//ste método guia o usuário através do processo de criação de um novo cliente, solicitando informações como nome, CPF, RG, telefone e e-mail
	public static void criarNovoCliente(Scanner input) {
	    Cliente cliente = new Cliente();

	    System.out.print("Nome completo : ");
	    input.nextLine();
	    cliente.setNome(input.nextLine());

	    System.out.print("CPF : ");
	    cliente.setCpf(input.nextLine());

	    System.out.print("RG : ");
	    cliente.setRg(input.nextLine());

	    System.out.print("Telefone : ");
	    cliente.setTel(input.nextLine());

	    System.out.print("Email : ");
	    cliente.setEmail(input.nextLine());

	    clienteDAO.criarCliente(cliente);
	    clienteDAO.mostrarDados(cliente.getNome());

	    int codCliente = clienteDAO.obterCodigoClientePorCPF(cliente.getCpf());

	    if (codCliente != -1) {
	        cliente.setCod(codCliente);
	    } else {
	        cliente.setCod(clienteDAO.obterUltimoCodigoCliente());
	    }

	    reserva.setCliente(cliente);
	}

	//Este método permite ao usuário escolher um destino disponível a partir de uma lista.
	public static void escolherDestino() {
	    DestinoDAO destinoDAO = new DestinoDAO();
	    Scanner input = new Scanner(System.in);

	    System.out.println("Escolha o Destino\n");

	    List<Destino> destinos = null;

	    try {
	        destinos = destinoDAO.listarDestinos();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    for (int i = 0; i < destinos.size(); i++) {
	        Destino destino = destinos.get(i);
	        System.out.printf("(%d) %s - Pais: %s - Valor: R$%.0f%n",
	                i + 1, destino.getNome(), destino.getPais(), destino.getValor());
	    }

	   
	    System.out.print("Destino: ");
	    int lugar = input.nextInt();

	    try {
	        Destino destinoEscolhido = destinos.get(lugar - 1); 
	        reserva.setDestino(destinoEscolhido);
	        reserva();
	    } catch (IndexOutOfBoundsException e) {
	        System.out.println("Escolha Inválida. Tente novamente.\n\n");
	        escolherDestino();
	    }
	}

	//Este método guia o usuário através do processo de fazer uma reserva, solicitando a data da viagem.
	public static void reserva() {	
		
		Scanner input = new Scanner(System.in);
		
		reserva.setDataReserva(new java.sql.Date(new Date().getTime()));
		
		System.out.print("Data da Viagem (dd/mm/yyyy): ");
		String dataString = input.next();
		
		try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataViagem = sdf.parse(dataString);
            java.sql.Date sqlDate = new java.sql.Date(dataViagem.getTime());
            reserva.setDataViagem(sqlDate);
            reservaDAO.criarReserva(reserva);
            System.out.println("Viagem marcada com sucesso!\n\n");
            menu();
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
            reserva();
        }
	}
	
	//Este método guia o usuário através do processo de exclusão de uma conta, solicitando o nome e CPF do cliente.
	public static void deletarConta() {
	    Scanner input = new Scanner(System.in);

	    System.out.print("Digite o nome completo do cliente: ");
	    String nome = input.nextLine();

	    System.out.print("Digite o CPF do cliente: ");
	    String cpf = input.nextLine();

	    int linhasAfetadas = clienteDAO.deletarConta(nome, cpf);

	    if (linhasAfetadas > 0) {
	        System.out.println("Conta deletada com sucesso.\n");
	        menu();
	    } else {
	        System.out.println("Não foi possível encontrar a conta com os dados fornecidos.\n");
	        deletarConta();
	    }
	}
	
	//Este método guia o usuário através do processo de atualização de informações da conta, como nome, CPF, RG, telefone e e-mail.
	public static void atualizarConta() {
	    Scanner input = new Scanner(System.in);

	    System.out.print("Digite o CPF do cliente: ");
	    String cpf = input.nextLine();

	    System.out.print("Digite o RG do cliente: ");
	    String rg = input.nextLine();
	    System.out.println();

	    Cliente cliente = clienteDAO.mostrarDadosPorCPF(cpf);

	    if (cliente != null && cliente.getRg().equals(rg)) {
	        System.out.println("Dados do cliente:");
	        System.out.println("1. Nome: " + cliente.getNome());
	        System.out.println("2. CPF: " + cliente.getCpf());
	        System.out.println("3. RG: " + cliente.getRg());
	        System.out.println("4. Telefone: " + cliente.getTel());
	        System.out.println("5. Email: " + cliente.getEmail());
	        System.out.println("0. Sair");

	        int opcao;
	        do {
	            System.out.print("Escolha o número do dado que deseja atualizar (ou 0 para sair): ");
	            opcao = input.nextInt();
	            input.nextLine(); 

	            switch (opcao) {
	                case 1:
	                    System.out.print("Novo nome: ");
	                    String novoNome = input.nextLine();
	                    cliente.setNome(novoNome);
	                    break;
	                case 2:
	                    System.out.print("Novo CPF: ");
	                    String novoCpf = input.nextLine();
	                    cliente.setCpf(novoCpf);
	                    break;
	                case 3:
	                    System.out.print("Novo RG: ");
	                    String novoRg = input.nextLine();
	                    cliente.setRg(novoRg);
	                    break;
	                case 4:
	                    System.out.print("Novo telefone: ");
	                    String novoTelefone = input.nextLine();
	                    cliente.setTel(novoTelefone);
	                    break;
	                case 5:
	                    System.out.print("Novo email: ");
	                    String novoEmail = input.nextLine();
	                    cliente.setEmail(novoEmail);
	                    break;
	                case 0:
	                    break;
	                default:
	                    System.out.println("Opção inválida. Tente novamente.");
	                    break;
	            }
	        } while (opcao != 0);

	        // Atualizar os dados na tabela
	        clienteDAO.atualizarCliente(cliente);

	        System.out.println("Dados atualizados com sucesso\n\n.");
	        menu();
	        
	    } else {
	        System.out.println("Não foi possível encontrar a conta com os dados fornecidos.\n");
	        atualizarConta();
	    }
	}

}