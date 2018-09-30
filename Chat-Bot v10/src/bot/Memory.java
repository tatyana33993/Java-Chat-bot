package bot;

import java.util.HashMap;
import java.util.Map;

import answers.Bye;
import answers.Hello;
import answers.HowAreYou;
import answers.TownsGame;
import answers.WhatAreYouDoing;
import answers.WhatCan;
import answers.WhatDay;
import answers.WhatTime;

public class Memory 
{
	String[] COMMON_PHRASES = { "Нет ничего ценнее слов, сказанных к месту и ко времени.",
			"Порой молчание может сказать больше, нежели уйма слов.",
			"Перед тем как писать/говорить всегда лучше подумать.", "Вежливая и грамотная речь говорит о величии души.",
			"Приятно когда текст без орфографических ошибок.", "Многословие есть признак неупорядоченного ума.",
			"Слова могут ранить, но могут и исцелять.", "Записывая слова, мы удваиваем их силу.",
			"Кто ясно мыслит, тот ясно излагает.", "Боюсь Вы что-то не договариваете." };
	String[] ELUSIVE_ANSWERS = { "Вопрос непростой, прошу тайм-аут на раздумья.",
			"Не уверен, что располагаю такой информацией.", "Может лучше поговорим о чём-то другом?",
			"Простите, но это очень личный вопрос.", "Не уверен, что Вам понравится ответ.",
			"Поверьте, я сам хотел бы это знать.", "Вы действительно хотите это знать?",
			"Уверен, Вы уже догадались сами.", "Зачем Вам такая информация?", "Давайте сохраним интригу?" };
	Map<String, String> PATTERNS_FOR_ANALYSIS = new HashMap<String, String>() {
		{
			// hello
			put("хай", "hello");
			put("привет", "hello");
			put("здорово", "hello");
			put("здравствуй", "hello");
			put("здаровки", "hello");
			// who
			put("кто\\s.*ты", "who");
			put("ты\\s.*кто", "who");
			// name
			put("как\\s.*зовут", "name");
			put("как\\s.*имя", "name");
			put("есть\\s.*имя", "name");
			put("какое\\s.*имя", "name");
			// whatcan
			put("что\\s.*можешь", "whatcan");
			put("что\\s.*умеешь", "whatcan");
			// howareyou
			put("как\\s.*дела", "howareyou");
			put("как\\s.*жизнь", "howareyou");
			// whatareyoudoing
			put("зачем\\s.*тут", "whatareyoudoing");
			put("зачем\\s.*здесь", "whatareyoudoing");
			put("что\\s.*делаешь", "whatareyoudoing");
			put("чем\\s.*занимаешься", "whatareyoudoing");
			put("что\\s.*творишь", "whatareyoudoing");
			put("чем\\s.*занят", "whatareyoudoing");
			// whatdoyoulike
			put("что\\s.*нравится", "whatdoyoulike");
			put("что\\s.*любишь", "whatdoyoulike");
			// iamfeelling
			put("кажется", "iamfeelling");
			put("чувствую", "iamfeelling");
			put("испытываю", "iamfeelling");
			// whatday
			put("какой\\s.*день", "whatday");
			put("какое\\s.*число", "whatday");
			put("день недели", "whatday");
			put("день", "whatday");
			put("число", "whatday");
			// whattime
			put("который\\s.*час", "whattime");
			put("сколько\\s.*время", "whattime");
			// bye
			put("прощай", "bye");
			put("пока", "bye");
			put("покеда", "bye");
			put("увидимся", "bye");
			put("до\\s.*свидания", "bye");
			// whatwatch
			put("что\\s.*посмотреть", "whatwatch");
			put("что\\s.глянуть", "whatwatch");
			// cartoon
			put("мультфильм", "cartoon");
			put("мультик", "cartoon");
			put("какой\\s.*мультфильм", "cartoon");
			put("подскажи\\s.*мультфильм", "cartoon");
			put("посоветуй\\s.*мультфильм", "cartoon");
			// film
			put("фильм", "film");
			put("фильмец", "film");
			put("какой\\s.*фильм", "film");
			put("подскажи\\s.*фильм", "film");
			put("посоветуй\\s.*фильм", "film");
			// series
			put("сериал", "series");
			put("сериальчик", "series");
			put("какой\\s.*сериал", "series");
			put("подскажи\\s.*сериал", "series");
			put("посоветуй\\s.*сериал", "series");
			// towns
			put("города", "towns");
		}
	};
	Map<String, Answer> ANSWERS_BY_PATTERNS = new HashMap<String, Answer>() {
		{
			//put("who", "Я обычный чат-бот.");
			//put("name", "Зовите меня Макс:)");
			//put("whatcan", "Пока я мало чего умею, но скоро этот список расширится."
			//		+ "А пока я могу подсказать время, посоветовать что вам посмотреть или вы можете просто поболтать со мной");
			//put("whatdoyoulike", "Мне нравится думать что я не просто программа.");
			//put("iamfeelling", "Как давно это началось? Расскажите чуть подробнее.");
			//put("yes", "Согласие есть продукт при полном непротивлении сторон.");
			put("hello", new Hello());
			put("bye", new Bye());
			put("howareyou", new HowAreYou());
			put("whatareyoudoing", new WhatAreYouDoing());
			put("whatday", new WhatDay());
			put("whattime", new WhatTime());
			put("whatcan", new WhatCan());
			put("towns", new TownsGame());
		}
	};
}
