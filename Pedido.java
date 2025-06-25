import java.util.ArrayList;
import java.util.Scanner;

// Enum para categorias de itens
enum Categoria {
    ALIMENTO,
    ELETRONICO,
    OUTROS
}

// Classe para representar um item de pedido
class ItemPedido {
    private String descricao;
    private int quantidade;
    private Categoria categoria;

    public ItemPedido(String descricao, int quantidade, Categoria categoria) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return categoria + " " + descricao + " " + quantidade;
    }
}

// Classe principal
public class Pedido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ItemPedido> listaPedidos = new ArrayList<>();

        System.out.println("Cadastro de Pedido\n");

        while (true) {
            System.out.print("Descrição do item (vazio para sair): ");
            String descricao = scanner.nextLine().trim();

            if (descricao.isEmpty()) {
                break;
            }

            System.out.print("Quantidade: ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            System.out.println("Selecione a categoria:");
            System.out.println("1. Alimento");
            System.out.println("2. Eletronico");
            System.out.println("3. Outros");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            Categoria categoria;
            switch (opcao) {
                case 1:
                    categoria = Categoria.ALIMENTO;
                    break;
                case 2:
                    categoria = Categoria.ELETRONICO;
                    break;
                default:
                    categoria = Categoria.OUTROS;
                    break;
            }

            ItemPedido item = new ItemPedido(descricao, quantidade, categoria);
            listaPedidos.add(item);
            System.out.println("Item adicionado!\n");
        }

        // Impressão final
        System.out.println("\n--- LISTA DE PEDIDOS ---");
        for (ItemPedido item : listaPedidos) {
            System.out.println(item);
        }

        scanner.close();
    }
}