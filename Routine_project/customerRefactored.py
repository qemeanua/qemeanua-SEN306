class Customer:
    def __init__(self, name, address, email, is_vip):
        self.name = name
        self.address = address
        self.email = email
        self.is_vip = is_vip
        self.orders = []

    def add_orders(self, order_list):
        for order in order_list:
            if order < 0:
                raise ValueError(f"Order can't be negative: {order}")
            self.orders.append(order)

    def get_total(self):
        return sum(self.orders)


def calculate_discount(customer_type):
    if customer_type == 1:
        return 0.1
    elif customer_type == 2:
        return 0.2
    else:
        return 0.0


def create_message(customer, total, is_vip):
    message = f"Hello {customer.name} of {customer.address}, your total is ${total}"
    if is_vip:
        message += " (VIP)"
    return message


def send_email_if_needed(email, message):
    if email:
        print(f"Sending email to {email}")
        print(f"Message: {message}")
        print("Email sent successfully!")


def process_customer(customer, customer_type, send_email=True):
    # Calculate order total
    order_total = customer.get_total()
    
    # Apply discount
    discount = calculate_discount(customer_type)
    final_total = order_total * (1 - discount)
    final_total = round(final_total, 2)
    
    # Create and show message
    message = create_message(customer, final_total, customer.is_vip)
    print(message)
    
    # Send email if requested
    if send_email:
        send_email_if_needed(customer.email, message)
    
    return final_total


# Example usage
if __name__ == "__main__":
    # Create a customer
    cust = Customer("John Doe", "123 Main St", "john@email.com", True)
    cust.add_orders([100, 50.5, 75.25])
    
    # Process the order (type 1 = silver, 10% discount)
    total = process_customer(cust, 1, True)
    print(f"Returned total: ${total}")