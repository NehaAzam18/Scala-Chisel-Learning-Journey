package lab8
import chisel3._ 
import org.scalatest._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class assignmentTest extends FreeSpec with ChiselScalatestTester{
  "memory_assignment test" in {
    test(new assignment){ c =>
    c.io.requestor(0).valid.poke(1.B)
    c.io.requestor(0).bits.poke(16.U)
    c.io.requestor(1).valid.poke(1.B)
    c.io.requestor(1).bits.poke(16.U)
    c.io.requestor(2).valid.poke(1.B)
    c.io.requestor(2).bits.poke(16.U)
    c.io.requestor(3).valid.poke(1.B)
    c.io.requestor(3).bits.poke(16.U)
    //c.io.memory_out.ready.poke(1.B)
    c.io.Readaddr.poke(3.U)
    c.io.Writeaddr.poke(2.U)
    c.clock.step(20)
    }
  }
}