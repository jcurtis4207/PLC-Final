next_token = ''
next_symbol = ''
# dictionaries for symbol table
symbol_table_value = {}
symbol_table_type = {}

def main():
    # read in input
    # enter all variable values and types into symbol table
    # eg value[A] = 5, type[A] = int; value[B] = 7, type[B] = int; etc
    EOF = False
    while EOF == False:
        lex()
        if next_token == 'UNARY_OP':
            unary_expr()
        elif (next_token == 'VARIABLE') or (next_token == 'INT_LIT'):
            binary_expr()
        else:
            error('Unrecognized Token')
        # update EOF
        # loop until end of file
    # if no errors, semantics are verified
    print('Semantic Analysis Completed With No Errors')
    return

def binary_expr():
    operand1_type, operand2_type = ''
    if next_token == 'VARIABLE':
        # check symbol table for current variable
        if not (next_symbol in symbol_table_value):
            error('Uninitialized Variable')
        operand1_type = symbol_table_type[next_symbol]
    else:
        operand1_type = 'int'
    operand1 = next_symbol
    lex()
    operator = next_token
    lex()
    if next_token == 'VARIABLE':
        # check symbol table for current variable
        if not (next_symbol in symbol_table_value):
            error('Uninitialized Variable')
        operand2_type = symbol_table_type[next_symbol]
    else:
        operand2_type = 'int'
    operand2 = next_symbol
    # check for type mismatch
    if symbol_table_type[operand1] != symbol_table_type[operand2]:
        error('Type Mismatch')
    return
    
def unary_expr():
    operand_type = ''
    operator = next_token
    lex()
    if next_token == 'VARIABLE':
        # check symbol table for current variable
        if not (next_symbol in symbol_table_value):
            error('Uninitialized Variable')
    return
    
def lex():
    # get next_token and next_symbol from parse tree
    return

def error(message):
    print(message)
    # throw error and halt execution
    return

if __name__ == '__main__':
    main()
