package lab1
import chisel3._

class task2(counterBit: UInt) extends Module{
  val io = IO(new Bundle {
    val result = Output(Bool())
  })
  val max = ((1.U << counterBit) - 1.U).asSInt
  val count = RegInit(0.S(4.W))

  when(count(3.U)){
    count := 0.S
  }.otherwise{
    count := count + 1.S
 
  }
  io.result := count(3.U)
  println(s"counter created max value $max")
}