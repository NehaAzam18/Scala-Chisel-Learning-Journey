;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Valid_Interf : 
  module Valid_Interf : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in : {valid : UInt<1>, bits : UInt<8>}, out : {valid : UInt<1>, bits : UInt<8>}}
    
    reg io_out_REG : {valid : UInt<1>, bits : UInt<8>}, clock @[Main.scala 22:21]
    io_out_REG.bits <= io.in.bits @[Main.scala 22:21]
    io_out_REG.valid <= io.in.valid @[Main.scala 22:21]
    io.out.bits <= io_out_REG.bits @[Main.scala 22:10]
    io.out.valid <= io_out_REG.valid @[Main.scala 22:10]
    
