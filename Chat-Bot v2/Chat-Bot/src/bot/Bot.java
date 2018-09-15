/**
 * Class Bot
 *
 * @author Tatyana
 */
package bot;
import java.util.*;
import java.util.regex.*;

public class Bot 
{
    final String[] COMMON_PHRASES = 
    	{
        "��� ������ ������ ����, ��������� � ����� � �� �������.",
        "����� �������� ����� ������� ������, ������ ���� ����.",
        "����� ��� ��� ������/�������� ������ ����� ��������.",
        "�������� � ��������� ���� ������� � ������� ����.",
        "������� ����� ����� ��� ��������������� ������.",
        "����������� ���� ������� ���������������� ���.",
        "����� ����� ������, �� ����� � ��������.",
        "��������� �����, �� ��������� �� ����.",
        "��� ���� ������, ��� ���� ��������.",
        "����� �� ���-�� �� �������������."
        };
    final String[] ELUSIVE_ANSWERS = 
    	{
        "������ ���������, ����� ����-��� �� ��������.",
        "�� ������, ��� ���������� ����� �����������.",
        "����� ����� ��������� � ���-�� ������?",
        "��������, �� ��� ����� ������ ������.",
        "�� ������, ��� ��� ���������� �����.",
        "��������, � ��� ����� �� ��� �����.",
        "�� ������������� ������ ��� �����?",
        "������, �� ��� ���������� ����.",
        "����� ��� ����� ����������?",
        "������� �������� �������?"
        };
    final Map<String, String> PATTERNS_FOR_ANALYSIS = new HashMap<String, String>() 
    {
    	{
        // hello
        put("���", "hello");
        put("������", "hello");
        put("�������", "hello");
        put("����������", "hello");
        // who
        put("���\\s.*��", "who");
        put("��\\s.*���", "who");
        // name
        put("���\\s.*�����", "name");
        put("���\\s.*���", "name");
        put("����\\s.*���", "name");
        put("�����\\s.*���", "name");
        // howareyou
        put("���\\s.*����", "howareyou");
        put("���\\s.*�����", "howareyou");
        // whatdoyoudoing
        put("�����\\s.*���", "whatdoyoudoing");
        put("�����\\s.*�����", "whatdoyoudoing");
        put("���\\s.*�������", "whatdoyoudoing");
        put("���\\s.*�����������", "whatdoyoudoing");
        // whatdoyoulike
        put("���\\s.*��������", "whatdoyoulike");
        put("���\\s.*������", "whatdoyoulike");
        // iamfeelling
        put("�������", "iamfeelling");
        put("��������", "iamfeelling");
        put("���������", "iamfeelling");
        // yes
        put("^��", "yes");
        put("��������", "yes");
        // whattime
        put("�������\\s.*���", "whattime");
        put("�������\\s.*�����", "whattime");
        // bye
        put("������", "bye");
        put("��������", "bye");
        put("��\\s.*��������", "bye");
    
    	}
    };
    final Map<String, String> ANSWERS_BY_PATTERNS = new HashMap<String, String>() 
    {
    	{
        put("hello", "������������, ��� ��� ������.");
        put("who", "� ������� ���-���.");
        put("name", "������ ���� ������ :)");
        put("howareyou", "�������, ��� �������������. � ���� �� ������.");
        put("whatdoyoudoing", "� ������ �������� � ������.");
        put("whatdoyoulike", "��� ��������� ������ ��� � �� ������ ���������.");
        put("iamfeelling", "��� ����� ��� ��������? ���������� ���� ���������.");
        put("yes", "�������� ���� ������� ��� ������ ������������� ������.");
        put("bye", "�� ��������. �������, ��� ��������.");
    
    	}
    };
    Pattern pattern; // ��� ���������
    Random random; // ��� ��������� �������
    Date date; // ��� ���� � �������

    public Bot() {
        random = new Random();
        date = new Date();
    }

    public String sayInReturn(String msg) {
        String say = (msg.trim().endsWith("?"))?
            ELUSIVE_ANSWERS[random.nextInt(ELUSIVE_ANSWERS.length)]:
            COMMON_PHRASES[random.nextInt(COMMON_PHRASES.length)];

            String message =
                String.join(" ", msg.toLowerCase().split("[ {,|.}?]+"));
            for (Map.Entry<String, String> o : PATTERNS_FOR_ANALYSIS.entrySet()) 
            {
                pattern = Pattern.compile(o.getKey());
                if (pattern.matcher(message).find())
                    if (o.getValue().equals("whattime")) return date.toString();
                    else return ANSWERS_BY_PATTERNS.get(o.getValue());
            }
        return say;
    }
}