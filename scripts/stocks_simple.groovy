import com.javaforu.dsl.stocks.bean.Stocks

println("\nExecuting ${this.class.name} @ ${new Date()}\n")

Stocks s = new Stocks()

Stocks.Buy buy1 = new Stocks.Buy()
buy1.symbol = 'goog'
buy1.limit = 625.0
buy1.qty = 300
buy1.goodFor = '60 days'

Stocks.Buy buy2 = new Stocks.Buy()
buy2.symbol = 'aapl'
buy2.market = -1
buy2.qty = 20
buy2.goodFor = 'eod'

s.buyOrders = [buy1, buy2]

Stocks.Sell sell = new Stocks.Sell()
sell.symbol = 'tsla'
sell.stopLimit = '98.5 97.0'
sell.qty = 500
sell.goodFor = '7 days'

s.sellOrders = [sell]

s.notes =
  '''   Commission is 9.99
   Also note, blah.. blah
   Cell (only if urgent): 555-444-1234'''

s.watch = ['Vanguard dividend ETFs', 'Corporate bond and senior loan ETFs']

return s