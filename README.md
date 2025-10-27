# Compilers - ANTLR TypeScript Project

这是一个使用 ANTLR 和 TypeScript 的编译器项目。

## 项目结构

```
compilers/
├── src/              # TypeScript 源代码
├── grammar/          # ANTLR 语法文件 (.g4)
├── generated/        # ANTLR 生成的解析器和词法分析器
├── dist/             # 编译后的 JavaScript 文件
├── package.json      # 项目依赖
└── tsconfig.json     # TypeScript 配置
```

## 安装依赖

```bash
npm install
```

## 使用说明

### 1. 生成 ANTLR 解析器

在 `grammar/` 目录下创建或修改 `.g4` 语法文件后，运行：

```bash
npm run antlr
```

这将从语法文件生成 TypeScript 代码到 `generated/` 目录。

### 2. 开发模式运行

```bash
npm run dev
```

### 3. 编译项目

```bash
npm run build
```

### 4. 运行编译后的代码

```bash
npm start
```

## 示例语法

项目包含一个简单的计算器语法示例 (`Hello.g4`)，支持：
- 变量赋值
- 基本算术运算 (+, -, *, /)
- 括号表达式

## 开发流程

1. 编写或修改 `.g4` 语法文件
2. 运行 `npm run antlr` 生成解析器
3. 在 `src/` 中编写 TypeScript 代码使用生成的解析器
4. 运行 `npm run dev` 测试
5. 运行 `npm run build` 编译发布

## 依赖项

- **antlr4ts**: ANTLR TypeScript 运行时
- **antlr4ts-cli**: ANTLR TypeScript 代码生成器
- **typescript**: TypeScript 编译器
- **ts-node**: 直接运行 TypeScript 文件

## License

ISC
