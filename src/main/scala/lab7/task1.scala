package lab7
import chisel3._ 
import chisel3.util._ 

class arbiter extends Bundle{
    val in = Flipped( Vec(2, Decoupled( UInt( 16.W ))))
    val out = Decoupled( UInt( 16.W ))
}

class task1 extends Module{
    val io = IO(new arbiter)
    val queue1 = Queue(io.in(0), 2)
    val queue2 = Queue(io.in(1), 2)
    val arb_priority = Module ( new Arbiter (  UInt (), 2) )
    arb_priority . io . in (0) <> queue1
    arb_priority . io . in (1) <> queue2

    io . out <> arb_priority . io . out
}
