package lab2
import chisel3._

class example extends Module{
    val io = IO( new Bundle{
        val x = Input(UInt(32.W))
        val y = Input(UInt(32.W))
        val sum = Output(UInt(32.W))
    })
    // io.sum := io.x + io.y
    
    io.sum := io.x+%io.y

}
