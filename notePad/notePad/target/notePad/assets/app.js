const clearBtn = document.getElementById("clearBtn");
const content = document.getElementById("content");
const title = document.getElementById("title");
const themeToggle = document.getElementById("themeToggle");
const autosaveStatus = document.getElementById("autosaveStatus");
const counter = document.getElementById("counter");

const DRAFT_TITLE_KEY = "notepad_draft_title";
const DRAFT_CONTENT_KEY = "notepad_draft_content";
const THEME_KEY = "notepad_theme";

// load draft + theme
window.addEventListener("DOMContentLoaded", () => {
    if (title && content) {
        const savedTitle = localStorage.getItem(DRAFT_TITLE_KEY);
        const savedContent = localStorage.getItem(DRAFT_CONTENT_KEY);
        if (savedTitle) title.value = savedTitle;
        if (savedContent) content.value = savedContent;
    }

    const savedTheme = localStorage.getItem(THEME_KEY);
    if (savedTheme === "light") {
        document.documentElement.classList.add("light-theme");
    }

    updateCounter();
});

// clear button
if (clearBtn && title && content) {
    clearBtn.addEventListener("click", () => {
        title.value = "";
        content.value = "";
        localStorage.removeItem(DRAFT_TITLE_KEY);
        localStorage.removeItem(DRAFT_CONTENT_KEY);
        autosaveStatus.textContent = "Cleared draft";
        updateCounter();
        content.focus();
    });
}

// autosave + counter
let autosaveTimer = null;

function scheduleAutosave() {
    if (!title || !content) return;
    if (autosaveTimer) clearTimeout(autosaveTimer);
    autosaveStatus.textContent = "Autosave: typing...";
    autosaveTimer = setTimeout(() => {
        localStorage.setItem(DRAFT_TITLE_KEY, title.value);
        localStorage.setItem(DRAFT_CONTENT_KEY, content.value);
        autosaveStatus.textContent = "Autosave: saved";
    }, 2000);
}

function updateCounter() {
    if (!counter || !content) return;
    const text = content.value.trim();
    const chars = text.length;
    const words = text ? text.split(/\s+/).length : 0;
    counter.textContent = `${words} words · ${chars} characters`;
}

if (title && content) {
    title.addEventListener("input", () => {
        scheduleAutosave();
    });
    content.addEventListener("input", () => {
        scheduleAutosave();
        updateCounter();
    });
}

// theme toggle
if (themeToggle) {
    themeToggle.addEventListener("click", () => {
        const root = document.documentElement;
        const isLight = root.classList.toggle("light-theme");
        localStorage.setItem(THEME_KEY, isLight ? "light" : "dark");
    });
}
