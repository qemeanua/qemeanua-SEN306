// Reflection - processCustomer Refactor

// What was wrong with the original?

The original code was a mess honestly. 9 parameters is way too many for one function. Names like `a`, `d`, `g`, `t` tell you nothing about what they do. Plus it was trying to do everything - calculate, print, email, update variables. That's just bad design.

Also there was a bug where it tries to update parameter `d` but that doesn't actually work in Java or Python. No validation either so negative orders would break everything.

// How I fixed it

I split everything into smaller pieces:

**Customer class** - holds customer data and their orders. Makes way more sense than passing 4 separate strings around.

**calculate_discount()** - simple function that returns discount based on type. Much cleaner than having if statements inside the main logic.

**create_message()** - handles just the message formatting. Nothing else.

**send_email_if_needed()** - takes care of email stuff only if there's an email address.

**process_customer()** - this is the main function now but it only has 3 parameters instead of 9. It just calls the other functions and coordinates everything.


//Why this is better
- Each function does ONE thing. Much easier to test and fix if something breaks
- Names actually make sense now
- Validation prevents negative orders from being added
- The function actually returns the total instead of trying (and failing) to update a parameter
- Can reuse the discount calculator or message formatter elsewhere if needed


//What I kept simple
I didn't go overboard with classes. Only created a Customer class because that made sense. The discount logic is just a simple function since it's only a few lines. No need to overcomplicate things.


// Testing 
- Regular customer (type 0) - 0% discount
- Silver customer (type 1) - 10% discount  
- Gold customer (type 2) - 20% discount
- VIP customers get "(VIP)" in message
- Email only sends if there's an address
- Negative orders get rejected

All worked fine.


//Summary
The original code probably worked but was hard to read and dangerous to change. Now it's organized, each part makes sense, and adding new features won't break everything else. That's really the whole point of refactoring.