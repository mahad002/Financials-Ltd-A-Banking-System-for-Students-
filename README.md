# Financials-Ltd-A-Banking-System-for-Students-
You have to implement a console-based Banking system in this assignment.


For this assignment, the task is to develop a Banking System focusing on serving the financial
needs of SDA students. The Bank provides a number of services to its clients (who are
restricted to SDA students only more on this in the following paragraphs

    Features of the system
      1. Account Management:
          The bank allows the customers to open new accounts. Individuals can open multiple accounts
          (up to 3 accounts per person are allowed). The bank supports opening and closing of
          accounts. Any time an account goes into negative, as a result of some transaction, the account
          becomes dormant. Dormant accounts need to be re-activated by depositing enough funds that
          bank balance becomes positive (+ 100 is the minimum allowed balance, below which account
          becomes dormant).
      2. User Management:
          Modifications to information of each account holder. For each account holder, their university
          ID number, and Address is recorded by the bank. Bank customers may ask for this information
          to be updated.
      3. Transactions:
          Bank supports usual transactions of withdraw and deposit. Additionally, bank keeps track of
          each transaction that takes place. This can be using a "Transaction Ledger" class (implemented
          by you of course). The ledger should support the functionality of locating transactions based on
          Account ID, or Account ID and Date. Each transaction object should also record the Date and
          time of transaction.
      4. Statement:
          Bank Customers may ask the bank for Statement of their account. Statement contains all the
          transactions, that have taken placed during a specific time period. (You should implement.
          toString( ) method for each transaction object to assist in getting nicely formatted Statement).
      5. Account Types:
          Bank support Saving and Current Accounts. Current accounts can also be owned jointly. That
          is, more than one person may be owner of an account. Also, there is a small penalty of 0.01 %
          of withdraw amount when taking funds from a Saving Account.
      6. You should try to implement various methods (override them) that supports clean coding.
         This includes methods such as. toString(), equals, compareTo etc.
      7. For this version, all records are kept in memory using java.util.collection classes. Later on,
         we will change to using a proper data base.
      8. Make sure to separate your business logic from UI (console based for now). You can use
         Bank as a "boundry” object for this purpose.
