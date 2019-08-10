<script>
    /*Bootlint是一个Bootstrap使用方面的错误检测工具*/
    javascript:(function () {
        var s = document.createElement("script");
        s.onload = function () {
            bootlint.showLintReportForCurrentDocument([]);
        };
        s.src = "https://maxcdn.bootstrapcdn.com/bootlint/latest/bootlint.min.js";
        document.body.appendChild(s)
    })();
</script>