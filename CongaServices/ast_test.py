import ast
import sys
import pprint
import re


def parse_tree (node):
    
    """
    Uses the stack to navigate our parse tree and discover Module, Classes,
    and Functions doc strings and all other comments. 
    """
    if type(node) is ast.Module:
        tree = dict(
          imports = [],
          importsFrom = [],
          classes = []  
        )
        for child in node.body:
            if type(child) is ast.Import: 
                for imp in child.names:
                    impTree = importTree(imp)
                    tree['imports'].append(impTree)
            elif type(child) is ast.ImportFrom:
                impfromtree = importFromTree(child)
                tree['importsFrom'].append(impfromtree)
            elif type(child) is ast.ClassDef:
                classDict = classTree(child)
                tree['classes'].append(classDict)

    return tree

def importTree(node):
    impTree = dict(
        name = node.name,
        asname = node.asname
    )
    return impTree

def importFromTree(node):
    impfrom = dict(
        module = node.module,
        imports = []
    )
    for imp in node.names:
        impTree = importTree(imp)
        impfrom['imports'].append(impTree)
    return impfrom

def classTree(node):
    classtree = dict(
        name = node.name,
        extends = [],
        functions = []
    )
    for bases in node.bases:
        classtree['extends'].append(bases.id)
    for child in node.body:
        if type(child) is ast.FunctionDef:
            funtionDict = funtionTree(child)
            classtree['functions'].append(funtionDict)
    return classtree

def funtionTree(node):
    funtionTree = dict(
        name = node.name,
        args = [],
        ret = dict()
    )

    for stm in node.body:
        if type(stm) is ast.Return:
            funtionTree['ret']=returnTree(stm)
        #elif type(stm) is ast.If:
        #    for stm1 in stm.body:
        #        if type(stm1) is ast.Return:
        #            funtionTree['ret'].append(returnTree(stm1))
        #elif type(stm) is ast.For:
        #    for stm1 in stm.body:
        #        if type(stm1) is ast.Return:
        #            funtionTree['ret'].append(returnTree(stm1))
    for arg in node.args.args:
        funtionTree['args'].append(arg.arg)
    return funtionTree

def returnTree(node):
    if type(node.value) is ast.Str:
        returnTree = dict(
            type = "String",
            value = node.value.s
        )
        return returnTree
    if type(node.value) is ast.List:
        isListString = False;
        values = [];
        for var in node.value.elts:
            if type(var) is ast.Str:
                isListString = True
                values.append(var.s)
        if isListString:
            returnTree = dict(
                type = "List<String>",
                values = values
            )
            return returnTree
    return dict()

def main ():
    f = open(sys.argv[1],'r')
    pt = ast.parse(f.read(), filename=sys.argv[1])

    tree = parse_tree(pt)

    #print(ast.dump(pt), "\n\n")
    pp = pprint.PrettyPrinter(indent=4)
    pp.pprint(tree)

if __name__ == '__main__':
    main()