;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Mem_bundle_intf : 
  module Mem_bundle_intf : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip data_in : UInt<32>[4], flip data_selector : UInt<2>, data_out : UInt<32>, flip addr : UInt<5>, flip wr_en : UInt<1>}
    
    io.data_out <= UInt<1>("h00") @[Main.scala 161:15]
    cmem memory : UInt<32>[32] @[Main.scala 163:18]
    when io.wr_en : @[Main.scala 164:21]
      write mport MPORT = memory[io.addr], clock
      MPORT <= io.data_in[io.data_selector]
      skip @[Main.scala 164:21]
    else : @[Main.scala 168:14]
      read mport io_data_out_MPORT = memory[io.addr], clock @[Main.scala 170:32]
      io.data_out <= io_data_out_MPORT @[Main.scala 170:15]
      skip @[Main.scala 168:14]
    
