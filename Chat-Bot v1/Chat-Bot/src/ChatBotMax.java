/**
 * Class ChatBotMax
 *
 * @author Tatyana
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*; // Для стиля документа
import bot.*;

class ChatBotMax extends JFrame implements ActionListener {

    final String TITLE_OF_PROGRAM = "Max: friendly bot";
    final int START_LOCATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;
    final String CHB_AI = "AI";
    final String BTN_ENTER = "Отправить";

    JTextPane dialogue; // Поле диалога
    JCheckBox ai;       // Включить/Выключить интелект
    JTextField message; // Поле для ввода сообщения
    Bot sbot;     // Класс бота
    SimpleAttributeSet botStyle; // Стиль текста бота
    SimpleAttributeSet userStyle; // Стиль текста пользователя

    public static void main(String[] args) {
        new ChatBotMax();
    }

    /**
     * Constructor:
     * Creating a window and all the necessary elements on it
     */
    ChatBotMax() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);
        setIconImage(new ImageIcon ( "C:/Users/Tatyana/Desktop/1.png" ).getImage());
        // Настройка диалогового поля
        dialogue = new JTextPane();
        dialogue.setEditable(false);
        dialogue.setContentType("text/html");
        dialogue.setVisible(true);
        dialogue.setBackground(new Color(255, 228, 181));
        
        JScrollPane scrollBar = new JScrollPane(dialogue);
        // Настройка сообщений бота и пользователя
        botStyle = new SimpleAttributeSet();
        StyleConstants.setItalic(botStyle, true);
        StyleConstants.setFontSize(botStyle, 13);
        StyleConstants.setForeground(botStyle, new Color(0, 0, 205));
        
        
        userStyle = new SimpleAttributeSet();
        StyleConstants.setItalic(userStyle, true);
        StyleConstants.setFontSize(userStyle, 13);
        StyleConstants.setForeground(userStyle, new Color(199, 21, 133));
        StyleConstants.setAlignment(userStyle, StyleConstants.ALIGN_RIGHT);
        // Панел для галочки, поля для сообщения и кнопка
        JPanel bp = new JPanel();
        bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS));
        
        message = new JTextField();
        message.setFont(new Font("Dialog", Font.ITALIC, 13));
        message.addActionListener(this);
        JButton enter = new JButton(BTN_ENTER);
        enter.addActionListener(this);
        // Добавление всех элементов окна
        bp.add(message);
        bp.add(enter);
        add(BorderLayout.CENTER, scrollBar);
        add(BorderLayout.SOUTH, bp);
        setVisible(true);
        sbot = new Bot(); // Создание объекта бота
    }

    /**
     * Listener of events from message field and enter button
     */
    @Override
    public void actionPerformed(ActionEvent event) {       
        if (message.getText().trim().length() > 0) {
            try {
                StyledDocument doc = dialogue.getStyledDocument();
                
                doc.insertString(doc.getLength(), message.getText() + "\n", 
                    userStyle);
                doc.insertString(doc.getLength(),
                    sbot.sayInReturn(message.getText()) + "\n",
                    botStyle);
            } catch(Exception e) { }
        }
        message.setText("");
        message.requestFocusInWindow();
    }
}