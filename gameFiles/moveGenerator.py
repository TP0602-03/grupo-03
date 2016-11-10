list = [3,4,1,5,2]
list2 = [2,1,3,4,5]
list3 = [5,3,2,1,4]
list4 = [1,5,4,2,3]
list5 = [4,2,5,3,1]
i = 0
for value in xrange(len(list)):
	print '{"number":' + value + ', "position": [' + value + ',0],"attribute:"'   '}'
	i += 1




{
  "plays": [{
    "number": 1,
    "position": [0, 0],
    "attribute":"num",
    "value": "1"
  }, {
    "number": 2,
    "position": [0, 1],
    "attribute":"num",
    "value": "1"
  }, {
    "number": 3,
    "position": [1, 0],
    "attribute":"num",
    "value": "1"
  }, {
    "number": 4,
    "position": [1, 1],
    "attribute":"num",
    "value": "1"
  }
  ]
}