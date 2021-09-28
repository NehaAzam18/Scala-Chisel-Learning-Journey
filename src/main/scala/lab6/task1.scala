package lab6
import chisel3 . _

class task1 ( val init : Int = 1) extends Module {
    val io = IO ( new Bundle {
    val out = Output ( Bool() )
    val in = Input ( UInt (4. W ) )
    })
    val state = RegInit ( 0. U (4. W ) )
    val flag = RegInit( 0.U (4.W))
    io.out := 0.B
    when (flag === 0.U){
        flag := flag + 1.U
        state := io.in
    }.otherwise{
        state := state >> 1
        io.out := state(0)
    }
}
