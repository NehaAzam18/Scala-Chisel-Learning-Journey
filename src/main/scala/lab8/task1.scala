package lab8
import chisel3 . _

class task1 extends Module {
    val width : Int = 8
    val io = IO ( new Bundle {
    val enable = Input ( Bool () )
    val write = Input ( Bool () )
    val read = Input ( Bool () )
    val addr = Input ( UInt (10. W ) )
    val mask = Input ( Vec (4 , Bool () ) )
    val dataIn = Input ( Vec (4 , UInt ( width . W ) ) )
    val dataOut = Output ( Vec (4 , UInt ( width . W ) ) )
    })
    // Create a 32 - bit wide memory that is byte - masked
    val mem = SyncReadMem (1024 , Vec (4 , UInt ( width . W ) ) )
    // Write with mask
    //io.dataout := DontCare
    val memm = Reg(Vec((4),UInt()))
    when(io.write){
        when(io.mask(0)){
            memm(0) := (io.dataIn(0))
            mem.write(io.addr, memm)
        }.elsewhen(io.mask(1)){
            memm(1) := (io.dataIn(1))
        }.elsewhen(io.mask(2)){
            memm(2) := (io.dataIn(2))
        }.elsewhen(io.mask(3)){
            memm(3) := (io.dataIn(3))
        }
    }
    io.dataOut <> mem.read(io.addr,io.enable)
    }

//println ( chisel3 . Driver . emitVerilog ( new MaskedReadWriteSmem ) )