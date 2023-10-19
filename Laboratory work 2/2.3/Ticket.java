import java.util.Date;

public class Ticket{
    private TicketRepository ticketRepository = TicketRepository.getInstance();


    private Plane plane;
    private Passenger passenger;
    private double price;
    private Date date;

    public Date getDate(){
        return date;
    }
    public double getPrice(){
        return price;
    }

    public Ticket(Plane plane, Passenger passenger, double price) {
        this.plane = plane;
        this.passenger = passenger;
        this.price = price;
        this.date = new Date();
        addToRepository();
    }

    private void addToRepository(){
        ticketRepository.addTicket(this);
    }
}
