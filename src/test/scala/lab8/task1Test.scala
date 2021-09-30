package lab8
import chisel3._ 
import org.scalatest._
import chiseltest._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task1Test extends FreeSpec with ChiselScalatestTester{
  "MaskedReadWriteSmem test" in {
    test(new task1){ c =>
    c.io.enable.poke(0.B)
    c.io.write.poke(1.B)
    c.io.read.poke(0.B)
    c.io.addr.poke(5.U)
    c.io.mask(0).poke(1.B)
    c.io.mask(1).poke(1.B)
    c.io.mask(2).poke(0.B)
    c.io.mask(3).poke(0.B)
    c.io.dataIn(0).poke(8.U)
    c.io.dataIn(1).poke(8.U)
    c.io.dataIn(2).poke(8.U)
    c.io.dataIn(3).poke(8.U)
    c.clock.step(1)
    c.io.dataIn(0).poke(4.U)
    c.io.dataIn(1).poke(4.U)
    c.io.dataIn(2).poke(4.U)
    c.io.dataIn(3).poke(4.U)
    c.clock.step(1)
    }
  }
}