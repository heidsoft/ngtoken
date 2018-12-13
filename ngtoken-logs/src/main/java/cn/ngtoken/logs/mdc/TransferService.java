package cn.ngtoken.logs.mdc;

public abstract class TransferService {
 
    public boolean transfer(long amount) {
        // connects to the remote service to actually transfer money
        return false;
    }
 
    abstract protected void beforeTransfer(long amount);
 
    abstract protected void afterTransfer(long amount, boolean outcome);
}