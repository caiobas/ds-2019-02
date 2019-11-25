<h1>Trabalho de Design de Software</h1>

<h2>Descrição do módulo</h2> Avaliação de expressões matemáticas só conhecidas em tempo de execução, mas posteriormente reutilizada inúmeras vezes, possivelmente ao longo de meses e anos. Neste caso, a expectativa é que a expressão possa ser compilada para bytecodes, em tempo de execução, oferecendo um ganho em desempenho. Nesta proposta, a biblioteca ASM deve ser utilizada.

<h2>Requisitos</h2>
<h5>R1</h5> Uma expressão matemática deve ser recebida como uma sequência de caracteres e os valores associados as variáveis da mesma.
<h5>R2</h5> A expressão matemática recebida deve ser avaliada com finalidade de verificar se a mesma foi utilizada anteriormente ou não, e caso não utilizada, deve ser convertida para bytecodes através da biblioteca ASM e armazenada para ser reutilizada posteriormente.
<h6>Observação: O uso da biblioteca ASM é uma restrição imposta ao desenvolvimento do módulo.</h6>
<h5>R3</h5> A expressão matemática está restrita a valores numéricos (tipo Double em Java).
<h5>R4</h5> A expressão matemática deverá ter um identificador ao ser armazenada, para que com este seja chamada posteriormente para uma execução.

<h2>Design</h2>
<h5>D1</h5> Deve-se criar uma classe Main aonde será executado o código para receber os dados da expressão.
<h5>D2</h5> Deve-se criar uma classe base ExpBase com o método calcule() que retorna um double.
<h5>D3</h5> Ao ser recebida uma String de uma expressão, se deve calcular o hashcode da mesma para verificar se a expressão já foi passada anteriormente ou não.
<h5>D4</h5> Caso a expressão recebida nunca tenha sido utilizada, deve ser usada a biblioteca ASM para criar uma classe dinamicamente e criar o metodo calcule() para que siga as especificações da expressão. A expressão deve ser transformada em bytecode. Segue trecho de código:

```
public static void realize(String classe, String metodo) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, IOException {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V11, ACC_PUBLIC, classe, null, "java/lang/Object", null);

        // Depende da quantidade de variáveis empregadas na expressão
        String descriptor = "(DD)D";

        MethodVisitor mtd = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, metodo,
                descriptor, null, null);
        mtd.visitCode();

        // -------------- START -----------------------
        // Executa operações conforme notação pós-fixada da expressão
        // Este trecho terá que ser construído dinamicamente a partir
        // da expressão fornecida.

        mtd.visitVarInsn(DLOAD, x);
        mtd.visitVarInsn(DLOAD, y);
        // Esta linha executa a operação matemática x + y
        mtd.visitInsn(DADD);

        // Multiplica resultado da adição por 200 (2E2)
        mtd.visitLdcInsn(2e2);
        mtd.visitInsn(DMUL);

        // ------------- END --------------------------

        mtd.visitInsn(DRETURN);
        mtd.visitMaxs(4, 4);
        mtd.visitEnd();
        cw.visitEnd();

         byte[] bytecodes = cw.toByteArray();

        Path dirCorrente = FileSystems.getDefault().getPath(".");
        final Path path = Path.of(dirCorrente.toString(), classe + ".class");

        try (FileOutputStream outputStream =
                     new FileOutputStream(path.toString())) {
            outputStream.write(bytecodes);
        }
```

<h6>Observação: Vale lembrar que para alterar o metodo calcule(), a expressão já deve estar transformada de infix para postfix por um compilador. Infix seria uma expressão do tipo 2 + 2. Enquanto a mesma expressão em postfix seria 2 2 +.</h6> 

<h5>D5</h5> Caso a expressão utilize a mesma variável mais de uma vez, armazenar ela quantas vezes for usada na expressão antes de iniciar a operação. Esta ação tem a finalidade de guardar o valor da variável para que não se perca ao executar uma operação.
<h5>D6</h5> Deve ser alterado o nome da nova classe para C####, aonde #### é o número do hashcode da expressão.
<h5>D7</h5> Caso a expressão recebida tenha sido utilizada, deve ser usado o Java Reflection para criar uma instância da mesma e chamar o método calcule() passando os valores (double) a serem utilizados naquela expressão. Segue trecho de código:

```
private static double avaliaExpressao(String classe, byte[] bytecodes,
                                          Object[] params) throws IllegalAccessException, InvocationTargetException {
        // Carregando a classe e executando o método
        DynamicClassLoader loader = new DynamicClassLoader();
        Class<?> clazz = loader.defineClass(classe, bytecodes);

        Method method = clazz.getDeclaredMethods()[0];

        return (double) method.invoke(null, params);
    }

    private static class DynamicClassLoader extends ClassLoader {
        public Class<?> defineClass(String name, byte[] b) {
            return defineClass(name, b, 0, b.length);
        }
```

<h5>D8</h5> As expressões convertidas para bytecode devem ser armazenadas em disco para que possam ser acessadas posteriormente para serem reutilizadas.
<h5>D9</h5> Ao se utilizar uma expressão já criada, o valor das variáveis deve ser passado via HashMap.

-------------------------------------------------------------------------------------------------------