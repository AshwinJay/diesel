println("\nExecuting ${this.class.name} @ ${new Date()}\n")

start().with {
  buyOrders =
    [
          buy().with {
            symbol = 'goog'
            limit = 625.0
            qty = 300
            goodFor = '60 days'
            return it
          },

          buy().with {
            symbol = 'aapl'
            market = -1
            qty = 20
            goodFor = 'eod'
            return it
          }
    ]

  sellOrders =
    [
          sell().with {
            symbol = 'tsla'
            stopLimit = '98.5 97.0'
            qty = 500
            goodFor = '7 days'
            return it
          }
    ]

  notes =
    '''  Commission is 9.99
  Also note, blah.. blah
  Cell (only if urgent): 555-444-1234'''

  watch = ['Vanguard dividend ETFs', 'Corporate bond and senior loan ETFs']

  return it
}