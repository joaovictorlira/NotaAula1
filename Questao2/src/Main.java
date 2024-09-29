import java.util.Scanner;

class Produto {
    String codigo;
    String nome;
    String tamanhoOuPeso;
    String cor;
    double valor;
    int quantidadeEstoque;

    // Construtor
    public Produto(String codigo, String nome, String tamanhoOuPeso, String cor, double valor, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.tamanhoOuPeso = tamanhoOuPeso;
        this.cor = cor;
        this.valor = valor;
    }

    // Metodo para exibir produto
    public void exibirProduto() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Tamanho/Peso: " + tamanhoOuPeso);
        System.out.println("Cor: " + cor);
        System.out.println("Valor: R$ " + valor);
        System.out.println("Quantidade em estoque: " + quantidadeEstoque);
    }

    public void atualizarEstoque(int quantidadeVendida) {
        this.quantidadeEstoque -= quantidadeVendida;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Produto produto = new Produto("001", "Camiseta", "G", "Preta", 50.0, 5);
        produto.exibirProduto();

        System.out.println("Quantas unidades deseja comprar?");
        int quantidadeVendida = sc.nextInt();

        if (quantidadeVendida <= produto.quantidadeEstoque) {
            double valorTotal = produto.valor * quantidadeVendida;
            System.out.println("Valor total sem desconto: R$ " + valorTotal);

            System.out.println("\nFormas de pagamentos disponíveis");
            System.out.println("1 - Pix\n2 - Espécie\n3 - Transferência\n4 - Débito\n5 - Crédito");
            int formaPagamento = sc.nextInt();

            double desconto = 0;


            switch (formaPagamento) {
                case 1:
                case 2:
                case 3:
                case 4:
                    desconto = 0.05 * valorTotal;
                    valorTotal -= desconto;
                    System.out.println("Valor total com desconto de 5% aplicado" + valorTotal);
                    break;
                case 5:
                    System.out.println("Você deseja parcelar em 3x sem juros? (1- Sim, 2- Não)");
                    int opcaoParcelamento = sc.nextInt();

                    if (opcaoParcelamento == 1) {
                        System.out.println("Valor parcelado em 3x de R$ " + valorTotal / 3);
                    } else if (opcaoParcelamento == 2) {
                        System.out.println("Digite o valor pago");
                        double valorPago = sc.nextInt();

                        if (valorPago > valorTotal) {
                            double troco = valorPago - valorTotal;
                            System.out.println("Troco R$ " + troco);
                        } else if (valorPago < valorTotal) {
                            System.out.println("Valor insuficiente");
                        }
                    }
                    break;
                default:
                    System.out.println("Forma de pagamento inválida");
                    return;
            }
        } else {
            System.out.println("Estoque insuficiente!");
        }

        produto.atualizarEstoque(quantidadeVendida);
        System.out.println("Venda realizada com sucesso!");
        System.out.println("Quantidades em estoque restantes "+ produto.quantidadeEstoque);


    }
}