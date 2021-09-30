package lab8
import chisel3._ 
import org.scalatest._
import chiseltest._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task2Test extends FreeSpec with ChiselScalatestTester{
  "forwardingOf2BankedMemory test" in {
    test(new task2()){ c =>
    c.io.enable.poke(1.B)
    c.io.write.poke(1.B)
    c.io.waddr.poke(2.U)
    c.io.raddr.poke(3.U)
    c.io.mask(0).poke(1.B)
    c.io.mask(1).poke(1.B)
    c.io.dataIn(0).poke(8.U)
    c.io.dataIn(1).poke(0.U)
    c.clock.step(20)
    // c.io.rdAddr.poke(5.U)
    // c.io.wrAddr.poke(5.U)
    // c.io.wrData.poke(4.U)
    // c.io.wr_en.poke(1.B)

    }
  }
}