package lab8
import chisel3 . _
import chisel3 . util . _

class assignment extends Module {
    val io = IO ( new Bundle {
    val memory_out = Vec (4 , Output ( UInt (32. W ) ) )
    val requestor = Vec (4 , Flipped ( Decoupled ( UInt (32. W ) ) ) )
    // decoupled = valid, ready, bits
    val Readaddr = Input ( UInt (5. W ) )
    val Writeaddr = Input ( UInt (5. W ) )
    })
    val queue0 = Queue(io.requestor(0), 4)
    val queue1 = Queue(io.requestor(1), 4)
    val queue2 = Queue(io.requestor(2), 4)
    val queue3 = Queue(io.requestor(3), 4)

    val arb = Module(new Arbiter(UInt(), 4))
    arb.io.in(0) <> queue0
    arb.io.in(1) <> queue1
    arb.io.in(2) <> queue2
    arb.io.in(3) <> queue3


    val mem = SyncReadMem (1024 , Vec (4 , UInt ( 32 . W ) ) )
    val memm = Reg(Vec((4),UInt()))
    arb.io.out.ready := 1.B
    when(io.requestor(0).valid){
        memm(0) := arb.io.out.bits
        mem.write(io.Writeaddr, memm)
    }.elsewhen(io.requestor(1).valid){
        memm(1) := arb.io.out.bits
        mem.write(io.Writeaddr, memm)
    }.elsewhen(io.requestor(2).valid){
        memm(2) := arb.io.out.bits
        mem.write(io.Writeaddr, memm)
    }.elsewhen(io.requestor(3).valid){
        memm(3) := arb.io.out.bits
        mem.write(io.Writeaddr, memm)
    }
    io . memory_out := mem.read (io . Readaddr )
}