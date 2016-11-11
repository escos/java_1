
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class SimpleBot extends TelegramLongPollingBot {

    static SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    public static void main(String[] args) {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new SimpleBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "Larry_Bot";
    }

    @Override
    public String getBotToken() {
        return "298595980:AAEOwZp9pqKrFODbwC3X2H2CjxOR9RG4idY";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        List<Task> taskList = MyTasks.readFromFile();
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "list":
                    MyTasks.printTaskList(taskList);
                    sendMsg(message, "Всего задач: " + taskList.size());
                    for (int i = 0; i < taskList.size(); i++) {
                        sendMsg(message, "Задача " + i + ": " + taskList.get(i).description + " дата выполнения: " + format1.format(taskList.get(i).date.getTime()));
                    }
                    break;
                case "date":
                    for (int i = 0; i < taskList.size(); i++) {
                        try {
                            Calendar calendar = Calendar.getInstance();
                            calendar.add(Calendar.DAY_OF_MONTH, +1);
                            if (taskList.get(i).date.before(calendar)) {
                                sendMsg(message,"НАПОМИНАНИЕ: ДО ВЫПОЛНЕНИЯ " + i + "-Й ЗАДАЧИ ОСТАЛОСЬ МЕНЕЕ 1 ДНЯ.");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    sendMsg(message,"Команда введена не верно!");
            }
        } else
            sendMsg(message, "Я не знаю что ответить на это");
    }


    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}

