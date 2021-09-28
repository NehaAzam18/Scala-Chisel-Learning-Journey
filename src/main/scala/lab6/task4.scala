package lab6
import chisel3 . _
import chisel3 . util . _

class task4 extends Module {
    val io = IO(new Bundle{
        val in = Flipped ( Decoupled ( UInt (8. W ) ) ) // valid = Input , ready =Output , bits = Input
        val out = Decoupled ( UInt (8. W ) )

    })

    io.out.bits := 0.U
    io.out.valid := 1.B

    val queue1 = Queue ( io . in , 5)
    val queue2 = Queue ( queue1 , 5)

    queue1.nodeq()
    queue2.nodeq()

    when(io.out.ready){
        //io . out <> queue2
        io.out.enq(queue2.deq())
    }
}

