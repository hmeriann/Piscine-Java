package ex00;

import javax.jws.soap.SOAPBinding;
import java.util.UUID;

public class   Transaction {
    private UUID    identifier;
    private User recipient;
    private User sender;
    private enum TransferCategory { DEBIT, CREDIT }
    private TransferCategory transferCategory;
    private Integer transferAmount;

    public Transaction(User sender, User recipient, Integer transferAmount) {
        this.identifier = new UUID(11111, 1111);
        this.recipient = recipient;
        this.sender = sender;
        this.transferAmount = transferAmount;

        if (transferAmount < 0) {
            transferCategory = TransferCategory.CREDIT;
        }
        else {
            transferCategory = TransferCategory.DEBIT;
        }
        if (sender.getBalance() < 0 || sender.getBalance() < transferAmount || (transferAmount < 0 && recipient.getBalance() < (-transferAmount)))
            System.out.print("Transaction cannot be completed: You have not right amount on your balance\n");
        else {
            sender.setBalance(sender.getBalance() - transferAmount);
            recipient.setBalance(recipient.getBalance() + transferAmount);
        }
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Integer getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Integer transferAmount) {
        this.transferAmount = transferAmount;
        if (transferAmount < 0)
            setTransferCategory(TransferCategory.CREDIT);
        else
            setTransferCategory(TransferCategory.DEBIT);
    }

    public TransferCategory getTransferCategory () {
        return transferCategory;
    }

    public void setTransferCategory(TransferCategory transferCategory) {
        this.transferCategory = transferCategory;
    }
}