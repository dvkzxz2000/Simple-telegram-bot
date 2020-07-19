import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "DariaKuh_bot";
    }

    @Override
    public String getBotToken() {
        return "858259408:AAEUZu6ZmYqPQ5WJymta_cjGbc2imvcHuvI";
    }


    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message.hasText() && message.getText().equals("/start")) {
            sendMsg(message, "Привет!");
        } else {
            sendMsg(message, message.getText());
        }
    }

    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}