
package lsita_tarefa;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class CaixaDeTexto extends JFrame {
    private JTextField caixa;
    private JButton add, remover;
    private JPanel checkBoxPanel, panel;
    private List<JCheckBox> lista;

    public CaixaDeTexto(){

        setTitle("Gerenciador de Listas");
        setSize(400, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        lista = new ArrayList<>();
        caixa = new JTextField(20);
        panel = new JPanel();
        checkBoxPanel = new JPanel();
        add = new JButton("Adicionar");
        remover = new JButton("Remover");

        
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(checkBoxPanel);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        panel.setPreferredSize(new Dimension(350, 300));
        panel.setMinimumSize(new Dimension(300, 150));


        add(panel);

        panel.add(caixa);
        panel.add(add);
        panel.add(scrollPane);
        panel.add(remover);

        caixa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    addCheckBox();
                }
            }
        });

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento){
                addCheckBox();
            }
        });

        remover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                removeCheckBox();
            }
        });
    }

    private void addCheckBox(){
        String text = caixa.getText();
                if(!text.isEmpty()){
                    JCheckBox checkBox = new JCheckBox(text);
                    lista.add(checkBox);
                    checkBoxPanel.add(checkBox);
                    checkBoxPanel.revalidate();
                    repaint();
                    caixa.setText("");
                }
    }

    private void removeCheckBox(){
        List<JCheckBox> caixasPraRemover = new ArrayList<>();
                for(JCheckBox checkBox : lista){
                    if(checkBox.isSelected()){
                        caixasPraRemover.add(checkBox);
                    }
                }

                for(JCheckBox checkBox: caixasPraRemover){
                    lista.remove(checkBox);
                    checkBoxPanel.remove(checkBox);
                }

                checkBoxPanel.revalidate();
                repaint();
    }
}
