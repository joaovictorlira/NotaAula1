
import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    String codigo;
    String nome;
    String tamanhoOuPeso;
    String cor;
    double valor;
    int quantidadeEstoque;


    public Produto() {

    }

    ;

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
        if (quantidadeVendida <= quantidadeEstoque) {
            this.quantidadeEstoque -= quantidadeVendida;
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        Produto novoProduto = null;

        
        System.out.println("Você deseja cadastrar um produto , ou realizar a compra?");
        System.out.println("1 - cadastrar 2 - comprar");
        int opcaoCadastroCompra = sc.nextInt();

        switch (opcaoCadastroCompra) {

            case 1:

                System.out.println("Cadastro de produto");


                System.out.println("Digite o codigo");
                String codigo = sc.nextLine();


                System.out.println("Digite o nome");
                String nome = sc.nextLine();

                System.out.println("Digite o tamanho ou peso");
                String tamanhoOuPeso = sc.nextLine();

                System.out.println("Digite a cor");
                String cor = sc.nextLine();

                System.out.println("Digite o valor");
                double valor = sc.nextDouble();

                System.out.println("Digite a quantidade em estoque");
                int quantidadeEstoque = sc.nextInt();
                sc.nextLine();

                novoProduto = new Produto(codigo, nome, tamanhoOuPeso, cor, valor, quantidadeEstoque);
                listaProdutos.add(novoProduto);
                novoProduto.exibirProduto();

                System.out.println("produto cadastrado com sucesso!");
                break;
            case 2:
                if(novoProduto == null) {
                    System.out.println("Produto não cadastrado");
                    break;
                }

                System.out.println("Quantas unidades deseja comprar?");
                int quantidadeVendida = sc.nextInt();

                if (quantidadeVendida <= novoProduto.quantidadeEstoque) {
                    double valorTotal = novoProduto.valor * quantidadeVendida;
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

                novoProduto.atualizarEstoque(quantidadeVendida);
                System.out.println("Venda realizada com sucesso!");
                System.out.println("Quantidades em estoque restantes " + novoProduto.quantidadeEstoque);
                break;

            default:
                System.out.println("Opcão inválida!");
        }

        sc.close();


    }
}