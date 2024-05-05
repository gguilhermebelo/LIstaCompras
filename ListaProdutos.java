import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaProdutos {
    private static ArrayList<String> produtos = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListaProdutos::criarGUI);
    }

    private static void criarGUI() {
        JFrame frame = new JFrame("Lista de Compras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Cabeçalho
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(60, 90, 200)); // Azul Escuro
        headerPanel.setPreferredSize(new Dimension(frame.getWidth(), 50)); // Altura do cabeçalho
        JLabel headerLabel = new JLabel("Bem-vindo à sua Lista de Compras");
        headerLabel.setForeground(Color.WHITE); // Texto em branco
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Estilo e tamanho da fonte
        headerPanel.add(headerLabel);
        frame.add(headerPanel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea(20, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.setBackground(Color.WHITE); // Fundo branco para contraste

        // Botão Adicionar Produto
        JButton adicionarButton = new JButton("Adicionar Produto");
        adicionarButton.setForeground(Color.WHITE); // Texto em branco
        adicionarButton.setBackground(new Color(60, 90, 200)); // Azul Escuro
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String produto = JOptionPane.showInputDialog(frame, "Digite o nome do produto:");
                if (produto != null && !produto.isEmpty()) {
                    adicionarProduto(produto);
                    atualizarLista(textArea, produtos);
                }
            }
        });
        buttonPanel.add(adicionarButton);

        // Botão Editar Produto
        JButton editarButton = new JButton("Editar Produto");
        editarButton.setForeground(Color.WHITE); // Texto em branco
        editarButton.setBackground(new Color(60, 90, 200)); // Azul Escuro
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String produto = JOptionPane.showInputDialog(frame, "Digite o nome do produto a ser editado:");
                if (produto != null && !produto.isEmpty()) {
                    editarProduto(frame, produto);
                    atualizarLista(textArea, produtos);
                }
            }
        });
        buttonPanel.add(editarButton);

        // Botão Excluir Produto
        JButton excluirButton = new JButton("Excluir Produto");
        excluirButton.setForeground(Color.WHITE); // Texto em branco
        excluirButton.setBackground(new Color(60, 90, 200)); // Azul Escuro
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String produto = JOptionPane.showInputDialog(frame, "Digite o nome do produto a ser excluído:");
                if (produto != null && !produto.isEmpty()) {
                    excluirProduto(produto);
                    atualizarLista(textArea, produtos);
                }
            }
        });
        buttonPanel.add(excluirButton);

        // Botão Sair
        JButton sairButton = new JButton("Sair");
        sairButton.setForeground(Color.WHITE); // Texto em branco
        sairButton.setBackground(new Color(60, 90, 200)); // Azul Escuro
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        buttonPanel.add(sairButton);

        frame.add(buttonPanel, BorderLayout.EAST);

        // Rodapé
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(60, 90, 200)); // Azul Escuro
        footerPanel.setPreferredSize(new Dimension(frame.getWidth(), 30)); // Altura do rodapé
        JLabel footerLabel = new JLabel("Criado por Guilherme Belo");
        footerLabel.setForeground(Color.WHITE); // Texto em branco
        footerPanel.add(footerLabel);
        frame.add(footerPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void atualizarLista(JTextArea textArea, ArrayList<String> lista) {
        textArea.setText("");
        for (String produto : lista) {
            textArea.append(produto + "\n");
        }
    }

    private static void adicionarProduto(String produto) {
        produtos.add(produto);
    }

    private static void editarProduto(JFrame frame, String produtoAntigo) {
        String novoNome = JOptionPane.showInputDialog(frame, "Digite o novo nome do produto:");
        if (novoNome != null && !novoNome.isEmpty()) {
            int index = produtos.indexOf(produtoAntigo);
            if (index != -1) {
                produtos.set(index, novoNome);
            } else {
                JOptionPane.showMessageDialog(frame, "Produto não encontrado.");
            }
        }
    }

    private static void excluirProduto(String produto) {
        produtos.remove(produto);
    }
}
