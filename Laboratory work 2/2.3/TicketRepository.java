import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketRepository {
    private List<Ticket> tickets = new ArrayList<>();

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }
    public void deleteTicket(Ticket ticket){
        tickets.remove(ticket);
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public double dateCount(String dateMinString, String dateMaxString)  {
        double sum = 0.00;
        try {

            Date dateMin = dateFormat.parse(dateMinString);
            Date dateMax = dateFormat.parse(dateMaxString);

            for (Ticket ticket : tickets.stream()
                    .filter(ticket -> ticket.getDate().after(dateMin))
                    .filter(ticket -> ticket.getDate().before(dateMax))
                    .toList()) {
                sum += ticket.getPrice();
            }
        }
        catch (Exception x)
        {
            x.printStackTrace();
        }
        return sum;
    }
    private static TicketRepository instance = null;

    public static TicketRepository getInstance() {
        if (instance == null)
            instance = new TicketRepository();
        return instance;
    }
}
