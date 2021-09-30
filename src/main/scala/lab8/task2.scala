package lab8
import chisel3 . _
import chisel3 . util . _
class task2 extends Module {
    val width : Int = 8
    val io = IO ( new Bundle {
    val enable = Input ( Bool () )
    val write = Input ( Bool () )
    val waddr = Input ( UInt (10. W ) )
    val raddr = Input ( UInt (10. W ) )
    //val addr = Input ( UInt (10. W ) )
    val mask = Input ( Vec (2 , Bool () ) )
    val dataIn = Input ( Vec (2 , UInt ( width . W ) ) )
    val dataOut = Output ( Vec (2 , UInt ( width . W ) ) )
    })
    // Create a 32 - bit wide memory that is byte - masked
    val mem = SyncReadMem (1024 , Vec (2 , UInt ( width . W ) ) )
    
    val wrDataReg = RegNext(io.dataIn)
    val doForwardReg = RegNext(io.waddr === io.raddr && io.enable)
    val memData = mem.read( io .raddr)
    when(io.enable){
        mem.write(io.waddr, io.dataIn, io.mask)
    }
    io.dataOut := Mux(doForwardReg, wrDataReg, memData)

}

