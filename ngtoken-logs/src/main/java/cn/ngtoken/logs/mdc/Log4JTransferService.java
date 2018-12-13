package cn.ngtoken.logs.mdc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Log4JTransferService extends TransferService {

    @Override
    protected void beforeTransfer(long amount) {
        log.info("Preparing to transfer " + amount + "$.");
    }
 
    @Override
    protected void afterTransfer(long amount, boolean outcome) {
        log.info(
          "Has transfer of " + amount + "$ completed successfully ? " + outcome + ".");
    }
}