package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public Order() {
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	public Date getMoment() {
		return moment;
	}
	
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
	}
	
	public void removeOrderItem(OrderItem orderItem) {
		orderItems.remove(orderItem);
	}	
	
	public double totalPrice(List<OrderItem> orderItem) {
		double totalPrice = 0;
		for (OrderItem oI : orderItems) {
			totalPrice += oI.subTotal();
		}
		return totalPrice;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ORDER SUMARY:\n");
		builder.append("\nOrder moment: ");
		builder.append(sdf.format(moment) + "\n");
		builder.append("Order status: ");
		builder.append(status + "\n");
		builder.append("\n" + client + "\n");
		builder.append("\nOrder items:\n");
		for (OrderItem dataItem : orderItems) {
			builder.append(dataItem + "\n");
		       }
		builder.append("\nTotal price: $" + String.format("%.2f", totalPrice(orderItems)));
		return builder.toString();
	}
	
}