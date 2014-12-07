#!/bin/bash

# online Abfrage:
# curl http://localhost:9987/stockquote/?wsdl
# wsimport -s . http://localhost:9987/stockquote/?wsdl

curl http://localhost:9987/stockquote/?wsdl | xmlstarlet fo >~/workspace/WSDL-Test/res/StockQuote2.wsdl

# clean
rm -rf bin/
rm -rf src-generated/

mkdir bin
mkdir src-generated

wsimport -Xnocompile -keep res/StockQuote2.wsdl -d src-generated/

