module Mem_bundle_intf(
  input         clock,
  input         reset,
  input  [31:0] io_data_in_0,
  input  [31:0] io_data_in_1,
  input  [31:0] io_data_in_2,
  input  [31:0] io_data_in_3,
  input  [1:0]  io_data_selector,
  output [31:0] io_data_out,
  input  [4:0]  io_addr,
  input         io_wr_en
);
`ifdef RANDOMIZE_MEM_INIT
  reg [31:0] _RAND_0;
`endif // RANDOMIZE_MEM_INIT
  reg [31:0] memory [0:31]; // @[Main.scala 163:18]
  wire [31:0] memory_io_data_out_MPORT_data; // @[Main.scala 163:18]
  wire [4:0] memory_io_data_out_MPORT_addr; // @[Main.scala 163:18]
  wire [31:0] memory_MPORT_data; // @[Main.scala 163:18]
  wire [4:0] memory_MPORT_addr; // @[Main.scala 163:18]
  wire  memory_MPORT_mask; // @[Main.scala 163:18]
  wire  memory_MPORT_en; // @[Main.scala 163:18]
  wire [31:0] _GEN_1 = 2'h1 == io_data_selector ? io_data_in_1 : io_data_in_0; // @[]
  wire [31:0] _GEN_2 = 2'h2 == io_data_selector ? io_data_in_2 : _GEN_1; // @[]
  assign memory_io_data_out_MPORT_addr = io_addr;
  assign memory_io_data_out_MPORT_data = memory[memory_io_data_out_MPORT_addr]; // @[Main.scala 163:18]
  assign memory_MPORT_data = 2'h3 == io_data_selector ? io_data_in_3 : _GEN_2;
  assign memory_MPORT_addr = io_addr;
  assign memory_MPORT_mask = 1'h1;
  assign memory_MPORT_en = io_wr_en;
  assign io_data_out = io_wr_en ? 32'h0 : memory_io_data_out_MPORT_data; // @[Main.scala 164:21 Main.scala 161:15 Main.scala 170:15]
  always @(posedge clock) begin
    if(memory_MPORT_en & memory_MPORT_mask) begin
      memory[memory_MPORT_addr] <= memory_MPORT_data; // @[Main.scala 163:18]
    end
  end
// Register and memory initialization
`ifdef RANDOMIZE_GARBAGE_ASSIGN
`define RANDOMIZE
`endif
`ifdef RANDOMIZE_INVALID_ASSIGN
`define RANDOMIZE
`endif
`ifdef RANDOMIZE_REG_INIT
`define RANDOMIZE
`endif
`ifdef RANDOMIZE_MEM_INIT
`define RANDOMIZE
`endif
`ifndef RANDOM
`define RANDOM $random
`endif
`ifdef RANDOMIZE_MEM_INIT
  integer initvar;
`endif
`ifndef SYNTHESIS
`ifdef FIRRTL_BEFORE_INITIAL
`FIRRTL_BEFORE_INITIAL
`endif
initial begin
  `ifdef RANDOMIZE
    `ifdef INIT_RANDOM
      `INIT_RANDOM
    `endif
    `ifndef VERILATOR
      `ifdef RANDOMIZE_DELAY
        #`RANDOMIZE_DELAY begin end
      `else
        #0.002 begin end
      `endif
    `endif
`ifdef RANDOMIZE_MEM_INIT
  _RAND_0 = {1{`RANDOM}};
  for (initvar = 0; initvar < 32; initvar = initvar+1)
    memory[initvar] = _RAND_0[31:0];
`endif // RANDOMIZE_MEM_INIT
  `endif // RANDOMIZE
end // initial
`ifdef FIRRTL_AFTER_INITIAL
`FIRRTL_AFTER_INITIAL
`endif
`endif // SYNTHESIS
endmodule
